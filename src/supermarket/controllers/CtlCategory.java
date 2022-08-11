/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.controllers;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import supermarket.classes.Category;
import supermarket.models.ModelCategory;
import supermarket.views.JFrameMain;

/**
 *
 * @author fercho
 */
public class CtlCategory implements ActionListener{
    static private ArrayList<String> categories;
    private JFrameMain main;

    public CtlCategory(JFrameMain jFrameMain) {
        this.categories = new ArrayList<String>();
        this.main = jFrameMain;
        
        this.loadCategories();
        this.main.jBtnAddCategory.addActionListener(this);
        this.main.jBtnDelCategory.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        // CREAR CATEGORY
        if(ae.getSource() == this.main.jBtnAddCategory){
            try{
                String categoryName = JOptionPane.showInputDialog("Ingresa el nombre de la Categoría");
                if(categoryName.trim().length() > 0 && !this.categoryExist(categoryName)){
                    String description = JOptionPane.showInputDialog("Ingresa la description de la Categoría");
                    if(description.trim().length() > 0){
                        Category category = new Category(categoryName, description);
                        ModelCategory mdCategory = new ModelCategory();
                        boolean creation = mdCategory.create(category);
                        if(creation){
                            this.loadCategories();
                            this.main.jCmbCategory.setSelectedItem(categoryName);
                        }
                        else{
                            JOptionPane.showMessageDialog(main, "Error en registro a base de datos", "Error", 1);
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(main, "Descripcion vacía", "Error al registrar categoría", 1);
                }
                else
                    JOptionPane.showMessageDialog(main, "Nombre incorrecto ó existente", "Error", 1);
            }
            catch(Exception e){
                
            }
        }
        // ELIMINAR CATEGORY
        if(ae.getSource() == this.main.jBtnDelCategory){
            try{
                ModelCategory mdCategory = new ModelCategory();
                boolean deleted;
                deleted = mdCategory.delete(this.main.jCmbCategory.getSelectedItem().toString());
                if(deleted){
                    this.loadCategories();
                }
                else{
                    JOptionPane.showMessageDialog(main, "No se pudo eliminar la categoría", "Transaccioń falllida", 0);
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(main, "Categoría no encontrada", "No existe", 0);
            }
        }
    }
    
    // Mëtodo para cargar las categorías
    private void loadCategories(){
        this.main.jCmbCategory.removeAllItems();
        ModelCategory mdCategory = new ModelCategory();
        this.categories = mdCategory.list();
        for (String category : this.categories) {
            this.main.jCmbCategory.addItem(category);
        }
    }
    
    // Métdo para determinar si ya existe una categoría
    private boolean categoryExist(String newCategory){
        for(String category: this.categories){
            if(category.trim().equals(newCategory.trim())){
                return true;
            }   
        }
        return false;
    }
    
}
