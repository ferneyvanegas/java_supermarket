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
import javax.swing.DefaultListModel;

import supermarket.classes.Sale;
/**
 *
 * @author fercho
 */
public class ModelSale {
    DbData dbData;

    public ModelSale() {
        this.dbData = new DbData();
    }
    
    public ArrayList listStrategies(){
        ArrayList<String> dealers = new ArrayList<String>();
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "SELECT * from tb_payment_strategies";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ResultSet result  = ps.executeQuery();
            
            while(result.next())
                dealers.add(result.getString(1) + ": " +result.getString(2));        
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
        }
        return dealers;
    }
    
    // Método que devuelve el valor establecido de interés para una estrategia con un usuario
    public double getInterest(int idCustomer, int idStrategy){
        double interest = -1;
        try(Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            
            String query="SELECT tb_payments.percentage_interest FROM tb_payments "
                        +"WHERE fk_customer_id = ? "
                        + "AND fk_payment_strategy_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idCustomer);
            ps.setInt(2, idStrategy);
            
            ResultSet result = ps.executeQuery();
            while(result.next()){
                return result.getInt(1);
            }
        }
        catch(Exception e){
            
        }

        return interest;
    }
    
    // Método que registra el valor establecido de interés para una estrategia con un usuario
    public boolean setInterest(int idCustomer, int idStrategy, double interest){
        try(Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            
            String query="INSERT INTO tb_payments(fk_payment_strategy_id, fk_customer_id, percentage_interest)"
                        + "VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idStrategy);
            ps.setInt(2, idCustomer);
            ps.setDouble(3, interest);
            
            // Devuelve el número de registros insertados
            int rowsInserted = ps.executeUpdate();
            if(rowsInserted > 0){
                return true;
            }
            else
                return false;
            
        }
        catch(Exception e){
            return false;
        }
    }
    
    // Método para registrar una venta
    public boolean createSale(Sale sale, DefaultListModel listCartModel){
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "INSERT INTO tb_sales(date, fk_customer_id, discount, total_value, fk_payment_id) "
                         + "VALUES(?,?,?,?,"
                         + "(SELECT pk_id from tb_payments WHERE fk_payment_strategy_id = ? AND fk_customer_id = ? LIMIT 1))";
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, sale.getDate());
            ps.setInt(2, sale.getIdCustomer());
            ps.setDouble(3, sale.getDiscount());
            ps.setDouble(4, sale.getTotalValue());
            ps.setInt(5, sale.getIdPayment());
            ps.setInt(6, sale.getIdCustomer());
            System.out.println(sale.getIdPayment());
            int rowsInserted = ps.executeUpdate(); // Registro de la venta
            if(rowsInserted > 0){
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if(generatedKeys.next()){
                    int saleId = generatedKeys.getInt(1);
                    for (int i = 0; i < listCartModel.getSize(); i++) {
                        String item = listCartModel.get(i).toString();
                        int productId = Integer.parseInt(item.substring(0, item.indexOf(":")));
                        int index = item.indexOf("$") + 1;
                        double value = Double.parseDouble(item.substring(index));
                        query = "INSERT INTO tb_products_sales(fk_sale_id, fk_product_id, single_price_value, quantity) "
                              + "VALUES(?,?,?,1)";
                        ps = conn.prepareStatement(query);
                        ps.setInt(1, saleId);
                        ps.setInt(2, productId);
                        ps.setDouble(3, value);
                        ps.executeUpdate();
                    }
                    return true;
                }
                else{
                    return false;
                }
            }
            else
                return false;
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
            return false;
        }
    }
}
