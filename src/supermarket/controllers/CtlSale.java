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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.sql.Date;

import supermarket.models.ModelSale;
import supermarket.views.JFrameMain;
import supermarket.classes.Sale;
/**
 *
 * @author fercho
 */
public class CtlSale implements ActionListener, MouseListener{
    private static DefaultListModel listCartModel = new DefaultListModel(); // El carrito de compras
    private JFrameMain main;

    public CtlSale(JFrameMain fFrameMain) {
        this.main = fFrameMain;
        
        this.loadStrategies();
        this.calcTotal();
        
        this.main.jCmbSaleCustomer.addActionListener(this);
        this.main.jCmbSaleStrategy.addActionListener(this);
        this.main.jListSaleProducts.addMouseListener(this);
        this.main.jBtnSaleQuitProduct.addActionListener(this);
        this.main.jBtnSaleRegister.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        // Agregar estrategias de pago
        if(ae.getSource() == this.main.jCmbSaleStrategy){
            if(this.main.jCmbSaleStrategy.getSelectedItem().toString() == ""){
                this.main.jLbSaleInterest.setText("");
            }
            else{
                String customer = this.main.jCmbSaleCustomer.getSelectedItem().toString().trim();
                int idCustomer = Integer.parseInt(customer.substring(0, customer.indexOf(":")));

                String strategy = this.main.jCmbSaleStrategy.getSelectedItem().toString().trim();
                int idStrategy = Integer.parseInt(strategy.substring(0, strategy.indexOf(":")));

                ModelSale mdSale = new ModelSale();

                double interest = mdSale.getInterest(idCustomer, idStrategy);

                if(interest == -1.0){
                    int resp = JOptionPane.showConfirmDialog(null, "No hay un Interés asignado a este usuario con este método de pago. "
                            + "Desea asignarle uno?", "Atención", JOptionPane.YES_NO_OPTION); // Si=0 | No=1
                    if(resp==0){
                        String interestValue = JOptionPane.showInputDialog(null, "Ingresa el porcentaje. Ej: 0.1 | Ej: 2");
                        try{
                            double interestVal = Double.parseDouble(interestValue);
                            boolean interestInserted = mdSale.setInterest(idCustomer, idStrategy, interestVal);
                            if(interestInserted){
                                JOptionPane.showMessageDialog(null, "Interés registrado. Se cargará automáticamente de ahora en adelante para este usuario "
                                        + "cuando se escoja la opción de pago establecida en esta transaccioń.", "Transacción completa", 1);
                                this.main.jLbSaleInterest.setText(interestVal + "");
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "No se puedo ingresar el interes", "Error", 0);
                                this.main.jCmbSaleStrategy.setSelectedItem("");
                                this.main.jLbSaleInterest.setText("");
                            }
                        }
                        catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Error con el número ingresado", "Error", 0);
                            this.main.jCmbSaleStrategy.setSelectedItem("");
                            this.main.jLbSaleInterest.setText("");
                        }
                    }
                    else{
                        this.main.jCmbSaleStrategy.setSelectedItem("");
                        this.main.jLbSaleInterest.setText("");
                    }
                }
                else{
                    this.main.jLbSaleInterest.setText(interest + "");
                }
                
            }
        }
        // Seleccionar un cliente
        else if(ae.getSource() == this.main.jCmbSaleCustomer){
            this.main.jCmbSaleStrategy.setSelectedItem("");
            this.main.jLbSaleInterest.setText("");
        }
        // Quitar un producto del carrito
        else if(ae.getSource() == this.main.jBtnSaleQuitProduct){
            try{
                int index = this.main.jListSaleProductsGroup.getSelectedIndex();
                this.listCartModel.remove(index);
                this.main.jListSaleProductsGroup.setModel(listCartModel);
                this.calcTotal();
            }
            catch(Exception e){
                
            }
        }
        // Realizar la compra
        else if(ae.getSource() == this.main.jBtnSaleRegister){
            if(this.validateData()){
                long miliseconds = System.currentTimeMillis();
                Date today = new Date(miliseconds);
                double totalValue = Double.parseDouble(this.main.jLbSaleTotal.getText().toString());
                
                // idCostumer
                String costumer = this.main.jCmbSaleCustomer.getSelectedItem().toString().trim();
                int idCostumer = Integer.parseInt(costumer.substring(0, costumer.indexOf(":")));
                
                // idPayment
                String payment = this.main.jCmbSaleStrategy.getSelectedItem().toString().trim();
                int idPayment = Integer.parseInt(payment.substring(0, payment.indexOf(":")));
                
                double discount = 0.0;
                
                if(this.main.jTxtSaleDiscount.getText().toString().trim().length() > 0){
                    String valuePersentage = this.main.jTxtSaleDiscount.getText().toString().trim();
                    try{
                        double discountPersentage = Double.parseDouble(valuePersentage);
                        discount = (totalValue * discountPersentage) / 100;
                    }
                    catch(Exception e){}
                }
                
                Sale sale = new Sale(today, discount, totalValue, idCostumer, idPayment);
                
                ModelSale mdSale = new ModelSale();
                boolean isSaved = mdSale.createSale(sale, listCartModel);
                
                if(isSaved){
                    this.clearForm();
                    JOptionPane.showMessageDialog(null, "Venta guardada", "Transacción Exitosa", 1);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se puedo registrar la venta", "Error", 0);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Faltan datos para registrar la venta", "Error", 0);
            }
        }
        
    }
    
    // Método para validar que los datos están completos para hacer la compra
    private boolean validateData(){
        /*
            a) Al menos debe haber un cliente
            b) Debe haber seleccionado una forma de pago
            c) Debe existir un interes fijado
            d) Debe haber al menos un producto en el carrito
        */
        if(
                this.main.jCmbSaleCustomer.getItemCount() > 0 &&
                this.main.jCmbSaleStrategy.getSelectedItem().toString().trim() != "" &&
                this.main.jLbSaleInterest.getText().toString().trim() != "" &&
                this.listCartModel.getSize() > 0
                
           ){
            return true;
        }
        return false;
    }
    
    // Método para cargar las estrategias de pago
    private void loadStrategies(){
        this.main.jCmbSaleStrategy.removeAllItems();
        ModelSale mdSale = new ModelSale();
        ArrayList<String> strategies = new ArrayList<String>();
        strategies = mdSale.listStrategies();
        this.main.jCmbSaleStrategy.addItem("");
        for(String strategy : strategies){
            this.main.jCmbSaleStrategy.addItem(strategy);
        }        
    }
    
    private void calcTotal(){
        if(this.listCartModel.getSize() == 0)
            this.main.jLbSaleTotal.setText("0.0");
        else{
            double total = 0;
            for (int i = 0; i < this.listCartModel.getSize(); i++) {
                String item = this.listCartModel.get(i).toString();
                int index = item.indexOf("$") + 1;
                double value = Double.parseDouble(item.substring(index));
                total+=value;
                this.main.jLbSaleTotal.setText(total + "");
            }
        }
        
    }
    
    // Método para limpiar el formulario
    private void clearForm(){
        this.main.jCmbSaleStrategy.setSelectedIndex(0);
        this.main.jLbSaleInterest.setText("");
        this.main.jTxtSaleDiscount.setText("");
        this.listCartModel.clear();
        this.main.jListSaleProductsGroup.setModel(listCartModel);
        this.calcTotal();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(me.getSource() == this.main.jListSaleProducts){
            this.listCartModel.addElement(this.main.jListSaleProducts.getSelectedValue().toString());
            this.main.jListSaleProductsGroup.setModel(listCartModel);
            this.calcTotal();
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
