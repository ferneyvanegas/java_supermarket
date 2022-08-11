/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import supermarket.classes.Product;
import supermarket.models.ModelCategory;
import supermarket.models.ModelProduct;
import supermarket.views.JFrameMain;

/**
 *
 * @author fercho
 */
public class CtlProduct implements ActionListener, MouseListener{
    private JFrameMain main;

    public CtlProduct(JFrameMain jFrameMain) {
        this.main = jFrameMain;
        
        this.loadProducts();
        this.main.jBtnProductAdd.addActionListener(this);
        this.main.jBtnProductEdit.addActionListener(this);
        this.main.jBtnProductDelete.addActionListener(this);
        this.main.jBtnProductClear.addActionListener(this);
        this.main.jTblProducts.addMouseListener(this);
        
        this.main.jBtnProductDelete.setEnabled(false);
        this.main.jBtnProductEdit.setEnabled(false);
        
        this.main.jLbIdProduct.setVisible(false);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        // CREAR PRODUCTO
        if(ae.getSource() == this.main.jBtnProductAdd){
            if(this.validateData()){
                ModelCategory mdCategory = new ModelCategory();
                int categoryId = mdCategory.search(this.main.jCmbCategory.getSelectedItem().toString());
                if(categoryId != 0){
                    String productName = this.main.jTxtProductName.getText();
                    double price = Double.parseDouble(this.main.jTxtProductPrice.getText());
                    boolean stock = this.main.jChkStock.isSelected();
                    ArrayList<String> dealers = new ArrayList<String>();
                    List<String> list = this.main.jListDealers.getSelectedValuesList();
                    for(String item: list){
                        dealers.add(item.substring(0, item.indexOf(":")));
                    }
                    Product product = new Product(productName, price, stock, categoryId, dealers);
                    
                    ModelProduct mdProduct = new ModelProduct();
                    boolean created = mdProduct.create(product);
                    if(created){
                        this.clearForm();
                        this.loadProducts();
                        JOptionPane.showMessageDialog(main, "Se ha creado el Producto", "Transacción exitosa", 1);
                    }
                    else{
                        JOptionPane.showMessageDialog(main, "Error al ingresar el producto", "Transaccioń falllida", 0);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(main, "Imposible asignar a Categoría seleccionada", "Cuidado", 0);
                }
            }
            else{
                JOptionPane.showMessageDialog(main, "Todos los campos con asterisco son obligatorios y especificos", "Cuidado", 0);
            }
        }
        // MODIFICAR PRODUCTO
        else if(ae.getSource() == this.main.jBtnProductEdit){
            if(this.validateData()){
                ModelCategory mdCategory = new ModelCategory();
                int categoryId = mdCategory.search(this.main.jCmbCategory.getSelectedItem().toString());
                if(categoryId != 0){
                    String productName = this.main.jTxtProductName.getText();
                    double price = Double.parseDouble(this.main.jTxtProductPrice.getText());
                    boolean stock = this.main.jChkStock.isSelected();
                    ArrayList<String> dealers = new ArrayList<String>();
                    List<String> list = this.main.jListDealers.getSelectedValuesList();
                    for(String item: list){
                        dealers.add(item.substring(0, item.indexOf(":")));
                    }
                    Product product = new Product(productName, price, stock, categoryId, dealers);
                    product.setId(Integer.parseInt(this.main.jLbIdProduct.getText().toString()));
                    
                    ModelProduct mdProduct = new ModelProduct();
                    boolean created = mdProduct.edit(product);
                    if(created){
                        this.clearForm();
                        this.loadProducts();
                        JOptionPane.showMessageDialog(main, "Se ha modificado el Producto", "Transacción exitosa", 1);
                    }
                    else{
                        JOptionPane.showMessageDialog(main, "Error al modificar el producto", "Transaccioń falllida", 0);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(main, "Imposible asignar a Categoría seleccionada", "Cuidado", 0);
                }
            }
            else{
                JOptionPane.showMessageDialog(main, "Todos los campos con asterisco son obligatorios y especificos", "Cuidado", 0);
            }
        }
        // ELIMINAR PRODUCTO
        else if(ae.getSource() == this.main.jBtnProductDelete){
            // Fijar Documento para Edición ó Eliminación
            int idProduct = Integer.parseInt(this.main.jLbIdProduct.getText().toString());
            try{
                ModelProduct mdProduct = new ModelProduct();
                boolean deleted;
                deleted = mdProduct.delete(idProduct);
                if(deleted){
                    this.clearForm();
                    this.loadProducts();
                    JOptionPane.showMessageDialog(main, "Se ha eliminado el producto", "Transacción exitosa", 1);
                }
                else{
                    JOptionPane.showMessageDialog(main, "Error al eliminar el producto", "Transaccioń falllida", 0);
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(main, "El producto no fue encontrado", "No existe", 0);
                this.clearForm();
            }
        }
        // LIMPIAR
        else if(ae.getSource() == this.main.jBtnProductClear){
            this.clearForm();
        }
    }
        
    // Método para validar que la informacioń del formulario sea correcta
    private boolean validateData(){
        if( this.main.jCmbCategory.getItemCount() > 0 && 
                
            this.main.jTxtProductName.getText().trim().length() > 0 && 
            this.main.jTxtProductName.getText().trim().length() < 101 && 
                
            this.main.jTxtProductPrice.getText().trim().length() > 0
                )
            try{
                double x = Double.parseDouble(this.main.jTxtProductPrice.getText().trim());
                return true;
            }
            catch(Exception e){
                return false;
            }
        return false;
    }
    
    // Método para limpiar el formulario
    private void clearForm(){
        this.main.jTxtProductName.setText("");
        this.main.jTxtProductPrice.setText("");
        this.main.jChkStock.setSelected(false);
        if(this.main.jCmbCategory.getItemCount() > 0)
            this.main.jCmbCategory.setSelectedIndex(0);
        this.main.jListDealers.clearSelection();
        this.main.jLbIdProduct.setText("");
        this.main.jBtnProductAdd.setEnabled(true);
        this.main.jBtnProductDelete.setEnabled(false);
        this.main.jBtnProductEdit.setEnabled(false);
    }
    
    //Método para cargar los productos
    private void loadProducts(){
        DefaultListModel listModel = new DefaultListModel(); // Para llenar el listado de la interfaz de ventas
        
        // Llenar la tabla
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Item");
        tableModel.addColumn("Producto");
        tableModel.addColumn("Precio");
        tableModel.addColumn("Stock");
        tableModel.addColumn("Categoría");
        
        String [] product = new String [5];
        
        ModelProduct mdProduct = new ModelProduct();
        ArrayList<ArrayList> products = mdProduct.list();
        
        for(ArrayList item: products){
           product[0] = (String) item.get(0);
           product[1] = (String) item.get(1);
           product[2] = (String) item.get(2);
           if(item.get(3).toString().trim().equals("0"))
               product[3] = "No disponible";
           else
               product[3] = "Disponible";
           product[4] = (String) item.get(4);
           tableModel.addRow(product);
           
           // Se construye String para agregar en listado de Ventas. Se agrega a listModel
           String productDesc = product[0] + ": " + product[1] + " $" + product[2];
           listModel.addElement(productDesc);
        }
        
        this.main.jTblProducts.setModel(tableModel); // Carga en la tabla
        this.main.jListSaleProducts.setModel(listModel); // Carga en la interfaz de ventas
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {        
    }

    @Override
    public void mousePressed(MouseEvent me) {        
    }

    @Override
    public void mouseReleased(MouseEvent me) { 
        if(me.getSource() == this.main.jTblProducts){
            try{
                this.main.jBtnProductAdd.setEnabled(false);
                this.main.jBtnProductDelete.setEnabled(true);
                this.main.jBtnProductEdit.setEnabled(true);
        
                int column = 0;
                int row = this.main.jTblProducts.getSelectedRow();
                String idProduct = this.main.jTblProducts.getModel().getValueAt(row, column).toString();
                this.main.jLbIdProduct.setText(idProduct);
                ModelProduct mdProduct = new ModelProduct();
                Product product = mdProduct.search(idProduct);
                this.main.jTxtProductName.setText(product.getProductName());
                this.main.jTxtProductPrice.setText(product.getPrice() + "");
                this.main.jChkStock.setSelected(product.isStock());
                ModelCategory mdCategory = new ModelCategory();
                this.main.jCmbCategory.setSelectedItem(mdCategory.search(product.getIdCategory()));
                
                // Proveedores
                int [] indexes = new int [product.getDealers().size()];
                int cont=0;
                for(String dealer: product.getDealers()){
                    this.main.jListDealers.setSelectedValue(dealer, true);
                    indexes[cont] = this.main.jListDealers.getSelectedIndex();
                    cont++;
                }
                this.main.jListDealers.setSelectedIndices(indexes);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(main, "Error al seleccionar el producto", "Error", 0);
                this.clearForm();
            }
        }  
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
    

