/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import supermarket.views.JFrameMain;
import supermarket.classes.Address;
import supermarket.classes.Dealer;
import supermarket.models.ModelDealer;

/**
 *
 * @author fercho
 */
public class CtlDealer implements ActionListener{
    private JFrameMain main;
    
    public CtlDealer (JFrameMain jFrameMain) {
        this.main = jFrameMain;
        
        this.loadDealers();
        
        this.main.jBtnDealerSave.addActionListener(this);
        this.main.jBtnDealerSearch.addActionListener(this);
        this.main.jBtnDealerEdit.addActionListener(this);
        this.main.jBtnDealerDelete.addActionListener(this);
        this.main.jBtnDealerClear.addActionListener(this);
        
        this.main.jBtnDealerDelete.setEnabled(false);
        this.main.jBtnDealerEdit.setEnabled(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        // CREAR PROVEEDOR
        if(ae.getSource() == this.main.jBtnDealerSave){
            if(this.validateData()){
                // Obtener los datos del proveedor
                String nit = this.main.jTxtNit.getText().trim();
                String rName = this.main.jTxtRName.getText().trim();
                String email = this.main.jTxtEmail.getText().trim();
                String agent = this.main.jTxtAgent.getText().trim();
                String webSite = this.main.jTxtWebSite.getText().trim();

                // Obtener los datos de la dirección
                String street = this.main.jCmbStreetDeal.getSelectedItem().toString().trim();
                String number = this.main.jTxtAddrNumDeal.getText().trim();
                String ward = this.main.jTxtAddrWardDeal.getText().trim();
                String city = this.main.jCmbCityDeal.getSelectedItem().toString().trim();

                Address address = new Address(street, number, ward, city);
                Dealer dealer = new Dealer(nit, rName, email, agent, webSite, address);
                ModelDealer mdDealer = new ModelDealer();
                boolean creation;
                creation = mdDealer.create(dealer);
                if(creation){
                    this.clearForm();
                    JOptionPane.showMessageDialog(main, "Se ha creado el proveedor", "Transacción exitosa", 1);
                }
                else{
                    JOptionPane.showMessageDialog(main, "Error al ingresar el proveedor", "Transaccioń falllida", 0);
                }
            }
            else{
                JOptionPane.showMessageDialog(main, "Todos los campos con asterisco son obligatorios y especificos", "Cuidado", 0);
            }
        }
        // BUSCAR PROVEEDOR
        else if(ae.getSource() == this.main.jBtnDealerSearch){
            // Fijar Nit para Edición ó Eliminación
            this.main.jTxtNit.setEnabled(false);
            this.main.jBtnDealerSave.setEnabled(false);
            this.main.jBtnDealerDelete.setEnabled(true);
            this.main.jBtnDealerEdit.setEnabled(true);
            
            String nitDealer = JOptionPane.showInputDialog(main, "Ingresa el nit del Proveedor");
            Dealer dealer = null;
            try{
                ModelDealer mdDealer = new ModelDealer();
                dealer = mdDealer.search(nitDealer);
                this.main.jTxtNit.setText(dealer.getNit());
                this.main.jTxtRName.setText(dealer.getRegisteredName());
                this.main.jTxtEmail.setText(dealer.getEmail());
                this.main.jTxtAgent.setText(dealer.getLegalAgent());
                this.main.jTxtWebSite.setText(dealer.getWebSite());
                this.main.jCmbStreetDeal.setSelectedItem(dealer.getAddress().getStreet());
                this.main.jTxtAddrNumDeal.setText(dealer.getAddress().getNumber());
                this.main.jTxtAddrWardDeal.setText(dealer.getAddress().getWard());
                this.main.jCmbCityDeal.setSelectedItem(dealer.getAddress().getCity());
                this.main.jLbIdDealer.setText(dealer.getId() + "");
                this.main.jLbIdAddressDeal.setText(dealer.getAddress().getId() + "");

                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(main, "El nit ingresado no fue encontrado", "No existe", 0);
                this.clearForm();
            }
        }
        // EDITAR PROVEEDOR
        else if(ae.getSource() == this.main.jBtnDealerEdit){
            if(this.validateData()){
                // Obtener los datos del proveedor
                String nit = this.main.jTxtNit.getText().trim();
                String rName = this.main.jTxtRName.getText().trim();
                String email = this.main.jTxtEmail.getText().trim();
                String agent = this.main.jTxtAgent.getText().trim();
                String webSite = this.main.jTxtWebSite.getText().trim();

                // Obtener los datos de la dirección
                String street = this.main.jCmbStreetDeal.getSelectedItem().toString().trim();
                String number = this.main.jTxtAddrNumDeal.getText().trim();
                String ward = this.main.jTxtAddrWardDeal.getText().trim();
                String city = this.main.jCmbCityDeal.getSelectedItem().toString().trim();

                Address address = new Address(street, number, ward, city);
                Dealer dealer = new Dealer(nit, rName, email, agent, webSite, address);
                ModelDealer mdDealer = new ModelDealer();
                
                address.setId(Integer.parseInt(this.main.jLbIdAddressDeal.getText()));
                dealer.setId(Integer.parseInt(this.main.jLbIdDealer.getText()));
                
                boolean edition;
                edition = mdDealer.edit(dealer);
                if(edition){
                    this.clearForm();
                    JOptionPane.showMessageDialog(main, "Se ha actualizado el proveedor", "Transacción exitosa", 1);
                }
                else{
                    JOptionPane.showMessageDialog(main, "Error al actualizar el proveedor", "Transaccioń falllida", 0);
                }
            }
            else{
                JOptionPane.showMessageDialog(main, "Todos los campos con asterisco son obligatorios y especificos", "Cuidado", 0);
            }
        }
        // ELIMINAR PROVEEDOR
        else if(ae.getSource() == this.main.jBtnDealerDelete){
            String idDealer = this.main.jLbIdDealer.getText();
            String idAddress = this.main.jLbIdAddressDeal.getText();
            try{
                ModelDealer mdDealer = new ModelDealer();
                boolean deleted;
                deleted = mdDealer.delete(Integer.parseInt(idDealer), Integer.parseInt(idAddress));
                if(deleted){
                    this.clearForm();
                    JOptionPane.showMessageDialog(main, "Se ha eliminado el proveedor", "Transacción exitosa", 1);
                }
                else{
                    JOptionPane.showMessageDialog(main, "Error al eliminar el proveedor", "Transaccioń falllida", 0);
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(main, "El nit ingresado no fue encontrado", "No existe", 0);
                this.clearForm();
            }
        }
        
        // LIMPIAR
        else if(ae.getSource() == this.main.jBtnDealerClear){
            this.clearForm();
        }
    }
    
    // Método para validar que la informacioń del formulario sea correcta
    private boolean validateData(){
        if( this.main.jTxtNit.getText().trim().length() > 0 && 
            this.main.jTxtNit.getText().trim().length() < 15 && 
                
            this.main.jTxtRName.getText().trim().length() > 0 && 
            this.main.jTxtRName.getText().trim().length() < 101 && 
                
            this.main.jTxtEmail.getText().trim().length() > 0 && 
            this.main.jTxtEmail.getText().trim().length() < 101 && 
                
            this.main.jTxtAgent.getText().trim().length() > 0 && 
            this.main.jTxtAgent.getText().trim().length() < 51 && 
                
            this.main.jTxtWebSite.getText().trim().length() > 0 && 
            this.main.jTxtWebSite.getText().trim().length() < 101 && 
                
            this.main.jCmbStreetDeal.getSelectedItem().toString().trim().length() < 101 && 
            this.main.jCmbStreetDeal.getSelectedItem().toString().trim().length() > 0 && 
                
            this.main.jTxtAddrNumDeal.getText().trim().length() < 4 && 
            this.main.jTxtAddrNumDeal.getText().trim().length() > 0 && 
                
            this.main.jTxtAddrWardDeal.getText().trim().length() < 101 && 
            this.main.jTxtAddrWardDeal.getText().trim().length() > 0 && 
                
            this.main.jCmbCityDeal.getSelectedItem().toString().trim().length() < 101 && 
            this.main.jCmbCityDeal.getSelectedItem().toString().trim().length() > 0
                )
            try{
                int x = Integer.parseInt(this.main.jTxtNit.getText().trim());
                int y = Integer.parseInt(this.main.jTxtAddrNumDeal.getText().trim());
                return true;
            }
            catch(Exception e){
                return false;
            }
        return false;
    }
    
    // Método para limpiar el formulario
    private void clearForm(){
        this.main.jTxtNit.setText("");
        this.main.jTxtRName.setText("");
        this.main.jTxtEmail.setText("");
        this.main.jTxtAgent.setText("");
        this.main.jTxtWebSite.setText("");
        this.main.jCmbStreetDeal.setSelectedIndex(0);
        this.main.jTxtAddrNumDeal.setText("");
        this.main.jTxtAddrWardDeal.setText("");
        this.main.jCmbCityDeal.setSelectedIndex(0);
   
        this.main.jLbIdDealer.setText("");
        this.main.jLbIdAddressDeal.setText("");
 
        this.main.jTxtNit.setEnabled(true);
        this.main.jBtnDealerSave.setEnabled(true);
        this.main.jBtnDealerDelete.setEnabled(false);
        this.main.jBtnDealerEdit.setEnabled(false);
        
        this.loadDealers(); // Recarga de Proveedores
        
    }
    
    private void loadDealers(){
        DefaultListModel listModel = new DefaultListModel();
        ModelDealer mdDealer = new ModelDealer();
        ArrayList<String> dealers = new ArrayList<String>();
        dealers = mdDealer.list();
        
        for(String dealer: dealers){
            listModel.addElement(dealer);
        }
        this.main.jListDealers.setModel(listModel);
    }
    
}
