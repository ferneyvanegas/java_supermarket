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

import supermarket.classes.Address;
import supermarket.classes.Customer;

/**
 *
 * @author fercho
 */
public class ModelCustomer {
   DbData dbData;

    public ModelCustomer() {
        this.dbData = new DbData();
    }
    
    public boolean create(Customer customer){
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "INSERT INTO tb_addresses(street, number, ward, city)"
                         + "VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getAddress().getStreet());
            ps.setString(2, customer.getAddress().getNumber());
            ps.setString(3, customer.getAddress().getWard());
            ps.setString(4, customer.getAddress().getCity());
            
            // Devuelve el número de registros insertados
            int rowsInserted = ps.executeUpdate();
            
            if(rowsInserted > 0){
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if(generatedKeys.next()){
                    int idAddress = generatedKeys.getInt(1);
                    query = "INSERT INTO tb_customers(document, first_name, second_name, first_surname, second_surname, fk_delivery_address)"
                          + "VALUES(?, ?, ?, ?, ?, ?)";
                    ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, customer.getDocument());
                    ps.setString(2, customer.getFirstName());
                    ps.setString(3, customer.getSecondName());
                    ps.setString(4, customer.getFirstSurname());
                    ps.setString(5, customer.getSecondSurname());
                    ps.setInt(6, idAddress);
                    rowsInserted = ps.executeUpdate();
                    if(rowsInserted > 0){
                        generatedKeys = ps.getGeneratedKeys();
                        if(generatedKeys.next()){
                            int idCustomer = generatedKeys.getInt(1);
                            query = "INSERT INTO tb_customer_phones(fk_customer_id, phone)"
                                  + "VALUES (?,?)";
                            for(String phone: customer.getPhones()){
                                ps = conn.prepareStatement(query);
                                ps.setInt(1, idCustomer);
                                ps.setString(2, phone);
                                rowsInserted = ps.executeUpdate();  
                            }
                            
                            if(rowsInserted > 0)
                                return true;
                        }
                    }
                }
            }
            return false;
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
            return false;
        }
    } 
    
    public Customer search(String document){
        Customer customer = null;
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "SELECT \n" +
                            "tb_customers.pk_id,\n" +
                            "tb_customers.document,\n" +
                            "tb_customers.first_name,\n" +
                            "tb_customers.second_name,\n" +
                            "tb_customers.first_surname,\n" +
                            "tb_customers.second_surname,\n" +
                            "tb_addresses.pk_id,\n" +
                            "tb_addresses.street,\n" +
                            "tb_addresses.number,\n" +
                            "tb_addresses.ward,\n" +
                            "tb_addresses.city\n" +
                            "FROM\n" +
                            "tb_customers INNER JOIN\n" +
                            "tb_addresses ON\n" +
                            "tb_customers.fk_delivery_address = tb_addresses.pk_id\n" +
                            "WHERE\n" +
                            "tb_customers.document = ?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, document);
            ResultSet result  = ps.executeQuery();
            
            while(result.next()){
                String street = result.getString(8);
                String number = result.getString(9);
                String ward = result.getString(10);
                String city = result.getString(11);
                Address address = new Address(street, number, ward, city);
                address.setId(result.getInt(7)); // El ID de la dirección
                customer = new Customer(
                                        result.getString(2),
                                        result.getString(3),
                                        result.getString(4),
                                        result.getString(5),
                                        result.getString(6),
                                        address
                                        );
                customer.setId(result.getInt(1)); // El ID del usuario

                // Teléfonos
                query = "SELECT * FROM tb_customer_phones WHERE fk_customer_id = ?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, result.getInt(1));
                result  = ps.executeQuery();
                while(result.next()){
                    customer.setPhone(result.getString(3));
                }
            }

            return customer;
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
            return customer;
        }
    }
    
    public boolean edit(Customer customer, String lastPhone){
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "UPDATE tb_addresses SET street = ?, number = ?, ward = ?, city = ? "
                         + "WHERE pk_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, customer.getAddress().getStreet());
            ps.setString(2, customer.getAddress().getNumber());
            ps.setString(3, customer.getAddress().getWard());
            ps.setString(4, customer.getAddress().getCity());
            ps.setInt(5, customer.getAddress().getId());
            
            // Devuelve el número de registros insertados
            int rowsUpdated = ps.executeUpdate();
            if(rowsUpdated > 0){
                query = "UPDATE tb_customers SET document=?, first_name=?, second_name=?, first_surname=?, second_surname=? "
                      + "WHERE pk_id=?";
                ps = conn.prepareStatement(query);
                ps.setString(1, customer.getDocument());
                ps.setString(2, customer.getFirstName());
                ps.setString(3, customer.getSecondName());
                ps.setString(4, customer.getFirstSurname());
                ps.setString(5, customer.getSecondSurname());
                ps.setInt(6, customer.getId());
                rowsUpdated = ps.executeUpdate();
                if(rowsUpdated > 0){
                    query = "DELETE FROM tb_customer_phones "
                          + "WHERE fk_customer_id=?";
                    ps = conn.prepareStatement(query);
                    ps.setInt(1, customer.getId());
                    rowsUpdated = ps.executeUpdate();
                    if(rowsUpdated > 0)
                        query = "INSERT INTO tb_customer_phones(fk_customer_id, phone)"
                                  + "VALUES (?,?)";
                            for(String phone: customer.getPhones()){
                                ps = conn.prepareStatement(query);
                                ps.setInt(1, customer.getId());
                                ps.setString(2, phone);
                                rowsUpdated = ps.executeUpdate();  
                            }
                            
                            if(rowsUpdated > 0)
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
    
    public boolean delete(int idCustomer, int idAddress){
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "DELETE FROM tb_customer_phones WHERE fk_customer_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idCustomer);
            int rowDeleted = ps.executeUpdate();
            if(rowDeleted > 0){
                query = "DELETE FROM tb_customers WHERE pk_id = ?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, idCustomer);
                rowDeleted = ps.executeUpdate();
                if(rowDeleted > 0){
                    query = "DELETE FROM tb_addresses WHERE pk_id = ?";
                    ps = conn.prepareStatement(query);
                    ps.setInt(1, idAddress);
                    rowDeleted = ps.executeUpdate(); 
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
    
    public ArrayList list(){
        ArrayList<String> dealers = new ArrayList<String>();
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "SELECT * from tb_customers";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ResultSet result  = ps.executeQuery();
            
            while(result.next())
                dealers.add(result.getString(1) + ": " +result.getString(3));        
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
        }
        return dealers;
    }
    
}
