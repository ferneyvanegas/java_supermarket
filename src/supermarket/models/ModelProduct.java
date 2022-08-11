/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.models;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import supermarket.classes.Product;
/**
 *
 * @author fercho
 */
public class ModelProduct {
    DbData dbData;

    public ModelProduct() {
        this.dbData = new DbData();
    }
    
    public boolean create(Product product){
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "INSERT INTO tb_products(product_name, price, stock, fk_category_id) "
                         + "VALUES(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getPrice());
            ps.setBoolean(3, product.isStock());
            ps.setDouble(4, product.getIdCategory());
            int rowsInserted = ps.executeUpdate();
            if(rowsInserted > 0){
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if(generatedKeys.next()){
                    int productId = generatedKeys.getInt(1);
                    for(String dealer: product.getDealers()){
                        // System.out.println("idProduct: " + productId + " | dealer: " + dealer);
                        query = "INSERT INTO tb_products_dealers(fk_product_id, fk_dealer_id)"
                              + "VALUES(?,?)";
                        ps = conn.prepareStatement(query);
                        ps.setInt(1, productId);
                        ps.setInt(2, Integer.parseInt(dealer));
                        ps.executeUpdate();
                    }
                }
                return true;
            }
            else
                return false;
        }
         catch(SQLException e){
            System.out.println("Error: " + e);
            return false;
        }
    }
    
    public ArrayList list(){
        ArrayList<Object> products = new ArrayList<Object>();
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "SELECT tb_products.pk_id, tb_products.product_name, tb_products.price, tb_products.stock, tb_categories.category_name "
                         + "FROM tb_products INNER JOIN tb_categories "
                         + "ON tb_products.fk_category_id = tb_categories.pk_id";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ResultSet result  = ps.executeQuery();
            
            // String [] product = new String [5];
            ArrayList<String> product;
            while(result.next()){
                product = new ArrayList<String>();
                product.add(result.getString(1));
                product.add(result.getString(2));
                product.add(result.getString(3));
                product.add(result.getString(4));
                product.add(result.getString(5));
                products.add(product);    
            }
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
        }
        return products;
    }

    public Product search(String idProduct){
        Product product = null;
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "SELECT * FROM tb_products WHERE pk_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(idProduct));
            ResultSet result  = ps.executeQuery();
            
            while(result.next()){
                
                String productName = result.getString(2);
                double price = result.getDouble(3);
                boolean stock = result.getBoolean(4);
                int idCategory = result.getInt(5);

                product = new Product(productName, price, stock, idCategory);

                // Proveedores
                query = "SELECT tb_dealers.pk_id, tb_dealers.registered_name "
                      + "FROM tb_products_dealers INNER JOIN tb_products INNER JOIN tb_dealers "
                      + "ON tb_dealers.pk_id = tb_products_dealers.fk_dealer_id "
                      + "AND tb_products.pk_id = tb_products_dealers.fk_product_id "
                      + "AND tb_products.pk_id = ?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(idProduct));
                result  = ps.executeQuery();
                
                ArrayList<String> dealers = new ArrayList<String>();
                while(result.next()){
                    dealers.add(result.getString(1) + ": " +result.getString(2));
                }
                product.setDealers(dealers);
            }

            return product;
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
            return product;
        }
    }
        
    public boolean edit(Product product){
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "UPDATE tb_products SET product_name = ?, price = ?, stock = ?, fk_category_id = ? "
                         + "WHERE pk_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getPrice());
            ps.setBoolean(3, product.isStock());
            ps.setInt(4, product.getIdCategory());
            ps.setInt(5, product.getId());
            
            // Devuelve el número de registros insertados
            int rowsUpdated = ps.executeUpdate();
            query = "DELETE FROM tb_products_dealers "
                  + "WHERE fk_product_id=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, product.getId());

            rowsUpdated = ps.executeUpdate();
            for(String dealer: product.getDealers()){
                // System.out.println("idProduct: " + product.getId() + " | dealer: " + dealer);
                query = "INSERT INTO tb_products_dealers(fk_product_id, fk_dealer_id)"
                      + "VALUES(?,?)";
                ps = conn.prepareStatement(query);
                ps.setInt(1, product.getId());
                ps.setInt(2, Integer.parseInt(dealer));
                ps.executeUpdate();
            }
            return true;
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
            return false;
        }
    } 
    
    public boolean delete(int idProduct){
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "DELETE FROM tb_products_dealers "
                  + "WHERE fk_product_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idProduct);
            int rowDeleted = ps.executeUpdate();
            if(rowDeleted > 0){
                query = "DELETE FROM tb_products WHERE pk_id = ?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, idProduct);
                rowDeleted = ps.executeUpdate();
                if(rowDeleted > 0){
                    return true;
                }
            }
            return false;
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
            return false;
        }
    }
}
