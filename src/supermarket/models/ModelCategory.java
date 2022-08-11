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

import supermarket.classes.Category;

/**
 *
 * @author fercho
 */
public class ModelCategory {
    DbData dbData;

    public ModelCategory() {
        this.dbData = new DbData();
    }
    
    public boolean create(Category category){
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "INSERT INTO tb_categories(category_name, category_description) "
                         + "VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getCategoryDescription());
            int rowsInserted = ps.executeUpdate();
            if(rowsInserted > 0)
                return true;
            else
                return false;
        }
         catch(SQLException e){
            System.out.println("Error: " + e);
            return false;
        }
    }
    
    public ArrayList list(){
        ArrayList<String> categories = new ArrayList<String>();
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "SELECT * from tb_categories";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ResultSet result  = ps.executeQuery();
            
            while(result.next())
                categories.add(result.getString(2));        
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
        }
        return categories;
    }
    
    public boolean delete(String categoryName){
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String query = "DELETE FROM tb_categories WHERE category_name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, categoryName);
            int rowDeleted = ps.executeUpdate();
            if(rowDeleted > 0){
                return true;
            }
            return false;
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
            return false;
        }
    
    }
    
    public int search(String categoryName){
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            int idCategory = 0;
            String query = "SELECT pk_id from tb_categories WHERE category_name=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, categoryName);
            
            ResultSet result  = ps.executeQuery();
            
            while(result.next()){
                idCategory = Integer.parseInt(result.getString(1));  
            }
            return idCategory;
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
            return 0;
        }
    }
    
    public String search(int idCategory){
        try (Connection conn = DriverManager.getConnection(this.dbData.getUrl(), 
                                                            this.dbData.getUser(), 
                                                            this.dbData.getPass())){
            String categoryName = null;
            String query = "SELECT category_name from tb_categories WHERE pk_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idCategory);
            
            ResultSet result  = ps.executeQuery();
            
            while(result.next()){
                categoryName = result.getString(1);  
            }
            return categoryName;
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
            return null;
        }
    }

}
