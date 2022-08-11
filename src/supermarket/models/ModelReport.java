/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author fercho
 */
public class ModelReport {
    DbData dbData;

    public ModelReport() {
        this.dbData = new DbData();
    }
    
    public ArrayList listProductByCustomer(int idCustomer){
        ArrayList<String> customerProducts = new ArrayList<String>();
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "SELECT tb_customers.first_name,\n" +
                        "tb_customers.second_name,\n" +
                        "tb_products.product_name,\n" +
                        "tb_sales.date\n" +
                        "FROM\n" +
                        "tb_customers INNER JOIN\n" +
                        "tb_products INNER JOIN\n" +
                        "tb_products_sales INNER JOIN\n" +
                        "tb_sales \n" +
                        "ON\n" +
                        "tb_customers.pk_id = tb_sales.fk_customer_id\n" +
                        "AND\n" +
                        "tb_sales.pk_id = tb_products_sales.fk_sale_id\n" +
                        "AND\n" +
                        "tb_products_sales.fk_product_id = tb_products.pk_id\n" +
                        "WHERE\n" +
                        "tb_customers.pk_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idCustomer);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                String reg = "El cliente " + result.getString(1) + " " + result.getString(2) + 
                             " adquirió el producto " + result.getString(3) +
                             " en la fecha " + result.getString(4);
                customerProducts.add(reg);
            }
        }
        catch(SQLException e){
            System.out.println("Error BD: " + e);
        }
        
        return customerProducts;
    }
}
