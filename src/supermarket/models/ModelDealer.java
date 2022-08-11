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
import supermarket.classes.Dealer;
/**
 *
 * @author fercho
 */
public class ModelDealer {
    DbData dbData;

    public ModelDealer() {
        this.dbData = new DbData();
    }
    
    public boolean create(Dealer dealer){
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "INSERT INTO tb_addresses(street, number, ward, city)"
                         + "VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dealer.getAddress().getStreet());
            ps.setString(2, dealer.getAddress().getNumber());
            ps.setString(3, dealer.getAddress().getWard());
            ps.setString(4, dealer.getAddress().getCity());
            
            // Devuelve el número de registros insertados
            int rowsInserted = ps.executeUpdate();
            
            if(rowsInserted > 0){
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if(generatedKeys.next()){
                    int idAddress = generatedKeys.getInt(1);
                    query = "INSERT INTO tb_dealers(nit, registered_name, fk_address_id, email, legal_agent, website)"
                          + "VALUES(?, ?, ?, ?, ?, ?)";
                    ps = conn.prepareStatement(query);
                    ps.setString(1, dealer.getNit());
                    ps.setString(2, dealer.getRegisteredName());
                    ps.setInt(3, idAddress);
                    ps.setString(4, dealer.getEmail());
                    ps.setString(5, dealer.getLegalAgent());
                    ps.setString(6, dealer.getWebSite());
                    rowsInserted = ps.executeUpdate();
                    if(rowsInserted > 0){
                        return true;
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
    
    public Dealer search(String nit){
        Dealer dealer = null;
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "SELECT \n" +
                            "tb_dealers.pk_id,\n" +
                            "tb_dealers.nit,\n" +
                            "tb_dealers.registered_name,\n" +
                            "tb_dealers.email,\n" +
                            "tb_dealers.legal_agent,\n" +
                            "tb_dealers.website,\n" +
                            "tb_addresses.pk_id,\n" +
                            "tb_addresses.street,\n" +
                            "tb_addresses.number,\n" +
                            "tb_addresses.ward,\n" +
                            "tb_addresses.city\n" +
                            "FROM\n" +
                            "tb_dealers INNER JOIN\n" +
                            "tb_addresses ON\n" +
                            "tb_dealers.fk_address_id = tb_addresses.pk_id\n" +
                            "WHERE\n" +
                            "tb_dealers.nit = ?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nit);
            ResultSet result  = ps.executeQuery();
            
            while(result.next()){
                String street = result.getString(8);
                String number = result.getString(9);
                String ward = result.getString(10);
                String city = result.getString(11);
                Address address = new Address(street, number, ward, city);
                address.setId(result.getInt(7)); // El ID de la dirección
                dealer = new Dealer(
                                        result.getString(2),
                                        result.getString(3),
                                        result.getString(4),
                                        result.getString(5),
                                        result.getString(6),
                                        address
                                        );
                dealer.setId(result.getInt(1)); // El ID del proveedor
            }

            return dealer;
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
            return dealer;
        }
    }
    
    public boolean edit(Dealer dealer){
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "UPDATE tb_addresses SET street = ?, number = ?, ward = ?, city = ? "
                         + "WHERE pk_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, dealer.getAddress().getStreet());
            ps.setString(2, dealer.getAddress().getNumber());
            ps.setString(3, dealer.getAddress().getWard());
            ps.setString(4, dealer.getAddress().getCity());
            ps.setInt(5, dealer.getAddress().getId());
            
            // Devuelve el número de registros insertados
            int rowsUpdated = ps.executeUpdate();
            if(rowsUpdated > 0){
                query = "UPDATE tb_dealers SET nit=?, registered_name=?, email=?, legal_agent=?, website=? "
                      + "WHERE pk_id=?";
                ps = conn.prepareStatement(query);
                ps.setString(1, dealer.getNit());
                ps.setString(2, dealer.getRegisteredName());
                ps.setString(3, dealer.getEmail());
                ps.setString(4, dealer.getLegalAgent());
                ps.setString(5, dealer.getWebSite());
                ps.setInt(6, dealer.getId());
                rowsUpdated = ps.executeUpdate();
                if(rowsUpdated > 0){
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
    
    public boolean delete(int idDealer, int idAddress){
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){

            String query = "DELETE FROM tb_dealers WHERE pk_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idDealer);
            int rowDeleted = ps.executeUpdate();
            if(rowDeleted > 0){
                query = "DELETE FROM tb_addresses WHERE pk_id = ?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, idAddress);
                rowDeleted = ps.executeUpdate(); 
                return true;
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
            String query = "SELECT * from tb_dealers";
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
