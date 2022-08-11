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
import javax.swing.ListModel;

import supermarket.classes.Address;
import supermarket.classes.Customer;
import supermarket.models.ModelCustomer;
import supermarket.views.JFrameMain;

/**
 *
 * @author fercho
 */
public class CtlCustomer implements ActionListener{
    static DefaultListModel listPhonesModel = new DefaultListModel();
    private JFrameMain main;

    public CtlCustomer(JFrameMain jFrameMain) {
        this.main = jFrameMain;
        
        this.loadCustomers();
        
        this.main.jBtnCustomerSave.addActionListener(this);
        this.main.jBtnCustomerSearch.addActionListener(this);
        this.main.jBtnCustomerEdit.addActionListener(this);
        this.main.jBtnCustomerDelete.addActionListener(this);
        this.main.jBtnCustomerClear.addActionListener(this);
        this.main.jBtnAddPhone.addActionListener(this);
        this.main.jBtnQuitPhone.addActionListener(this);
        
        this.main.jBtnCustomerDelete.setEnabled(false);
        this.main.jBtnCustomerEdit.setEnabled(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        // CREAR CLIENTE
        if(ae.getSource() == this.main.jBtnCustomerSave){
            if(this.validateData()){
                // Obtener los datos del cliente
                String document = this.main.jTxtDocument.getText().trim();
                String fName = this.main.jTxtFName.getText().trim();
                String sName = this.main.jTxtSName.getText().trim();
                String fSurname = this.main.jTxtFSurname.getText().trim();
                String sSurname = this.main.jTxtSSurname.getText().trim();

                // Obtener los datos de la dirección
                String street = this.main.jCmbStreet.getSelectedItem().toString().trim();
                String number = this.main.jTxtAddrNum.getText().trim();
                String ward = this.main.jTxtAddrWard.getText().trim();
                String city = this.main.jCmbCity.getSelectedItem().toString().trim();

                // Teléfonos
                ArrayList<String> phones = new ArrayList<String>();
                for (int i = 0; i < this.listPhonesModel.getSize(); i++) {
                    phones.add(this.listPhonesModel.get(i).toString());
                }

                Address address = new Address(street, number, ward, city);
                Customer customer = new Customer(document, fName, sName, fSurname, sSurname, address, phones);
                ModelCustomer mdCustomer = new ModelCustomer();
                boolean creation;
                creation = mdCustomer.create(customer);
                if(creation){
                    this.clearForm();
                    JOptionPane.showMessageDialog(main, "Se ha creado el usuario", "Transacción exitosa", 1);
                }
                else{
                    JOptionPane.showMessageDialog(main, "Error al ingresar el usuario", "Transaccioń falllida", 0);
                }
            }
            else{
                JOptionPane.showMessageDialog(main, "Todos los campos con asterisco son obligatorios y especificos", "Cuidado", 0);
            }
        }
        // BUSCAR CLIENTE
        else if(ae.getSource() == this.main.jBtnCustomerSearch){
            // Fijar Documento para Edición ó Eliminación
            this.main.jTxtDocument.setEnabled(false);
            this.main.jBtnCustomerSave.setEnabled(false);
            this.main.jBtnCustomerDelete.setEnabled(true);
            this.main.jBtnCustomerEdit.setEnabled(true);
            
            String documentCustomer = JOptionPane.showInputDialog(main, "Ingresa el número de documento");
            Customer customer = null;
            try{
                ModelCustomer mdCustomer = new ModelCustomer();
                customer = mdCustomer.search(documentCustomer);
                this.main.jTxtDocument.setText(customer.getDocument());
                this.main.jTxtFName.setText(customer.getFirstName());
                this.main.jTxtSName.setText(customer.getSecondName());
                this.main.jTxtFSurname.setText(customer.getFirstSurname());
                this.main.jTxtSSurname.setText(customer.getSecondSurname());
                this.main.jCmbStreet.setSelectedItem(customer.getAddress().getStreet());
                this.main.jTxtAddrNum.setText(customer.getAddress().getNumber());
                this.main.jTxtAddrWard.setText(customer.getAddress().getWard());
                this.main.jCmbCity.setSelectedItem(customer.getAddress().getCity());
                
                // Teléfonos
                for(String phone: customer.getPhones()){
                    this.listPhonesModel.addElement(phone);
                    this.main.jLstPhones.setModel(this.listPhonesModel);
                }
                
                this.main.jLbIdCustomer.setText(customer.getId() + "");
                this.main.jLbIdAddress.setText(customer.getAddress().getId() + "");
                this.main.jLbPhone.setText(customer.getPhone(0));
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(main, "El documento ingresado no fue encontrado", "No existe", 0);
                this.clearForm();
            }
        }
        // EDITAR CLIENTE
        else if(ae.getSource() == this.main.jBtnCustomerEdit){
            if(this.validateData()){
                // Obtener los datos del cliente
                String document = this.main.jTxtDocument.getText().trim();
                String fName = this.main.jTxtFName.getText().trim();
                String sName = this.main.jTxtSName.getText().trim();
                String fSurname = this.main.jTxtFSurname.getText().trim();
                String sSurname = this.main.jTxtSSurname.getText().trim();

                // Obtener los datos de la dirección
                String street = this.main.jCmbStreet.getSelectedItem().toString().trim();
                String number = this.main.jTxtAddrNum.getText().trim();
                String ward = this.main.jTxtAddrWard.getText().trim();
                String city = this.main.jCmbCity.getSelectedItem().toString().trim();

                // Teléfonos
                ArrayList<String> phones = new ArrayList<String>();
                for (int i = 0; i < this.listPhonesModel.getSize(); i++) {
                    phones.add(this.listPhonesModel.get(i).toString());
                }

                Address address = new Address(street, number, ward, city);
                Customer customer = new Customer(document, fName, sName, fSurname, sSurname, address, phones);
                
                address.setId(Integer.parseInt(this.main.jLbIdAddress.getText()));
                customer.setId(Integer.parseInt(this.main.jLbIdCustomer.getText()));
                
                ModelCustomer mdCustomer = new ModelCustomer();
                boolean edition;
                edition = mdCustomer.edit(customer, this.main.jLbPhone.getText());
                if(edition){
                    this.clearForm();
                    JOptionPane.showMessageDialog(main, "Se ha actualizado el usuario", "Transacción exitosa", 1);
                }
                else{
                    JOptionPane.showMessageDialog(main, "Error al actualizar el usuario", "Transaccioń falllida", 0);
                }
            }
            else{
                JOptionPane.showMessageDialog(main, "Todos los campos con asterisco son obligatorios y especificos", "Cuidado", 0);
            }
        }
        // ELIMINAR CLIENTE
        else if(ae.getSource() == this.main.jBtnCustomerDelete){
            // Fijar Documento para Edición ó Eliminación
            String idCustomer = this.main.jLbIdCustomer.getText();
            String idAddress = this.main.jLbIdAddress.getText();
            try{
                ModelCustomer mdCustomer = new ModelCustomer();
                boolean deleted;
                deleted = mdCustomer.delete(Integer.parseInt(idCustomer), Integer.parseInt(idAddress));
                if(deleted){
                    this.clearForm();
                    JOptionPane.showMessageDialog(main, "Se ha eliminado el usuario", "Transacción exitosa", 1);
                }
                else{
                    JOptionPane.showMessageDialog(main, "Error al eliminar el usuario", "Transaccioń falllida", 0);
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(main, "El documento ingresado no fue encontrado", "No existe", 0);
                this.clearForm();
            }
        }
        
        // LIMPIAR
        else if(ae.getSource() == this.main.jBtnCustomerClear){
            this.clearForm();
        }
        
        // AGREGAR TELEFONO
         else if(ae.getSource() == this.main.jBtnAddPhone){
             try{
                String newPhone = JOptionPane.showInputDialog("Ingresa teléfono");
                if(newPhone.trim().length() < 16 && newPhone.trim().length() > 0 ){
                    Double.parseDouble(newPhone);
                    this.listPhonesModel.addElement(newPhone);
                    this.main.jLstPhones.setModel(this.listPhonesModel);
                }
                else{
                    JOptionPane.showMessageDialog(main, "Número no permitido", "Error", 0);
                }
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(main, "Número no permitido", "Error", 0);
             }
         }
        
        // QUITAR TELEFONO
         else if(ae.getSource() == this.main.jBtnQuitPhone){
             try{
               
                int index = this.main.jLstPhones.getSelectedIndex();
                this.listPhonesModel.remove(index);
                this.main.jLstPhones.setModel(this.listPhonesModel);
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(main, "Error al retirar el número", "Error", 0);
             }
         }
        
    }
    
    // Método para validar que la informacioń del formulario sea correcta
    private boolean validateData(){
        if( this.main.jTxtDocument.getText().trim().length() > 0 && 
            this.main.jTxtDocument.getText().trim().length() < 16 && 
                
            this.main.jTxtFName.getText().trim().length() > 0 && 
            this.main.jTxtFName.getText().trim().length() < 101 && 
                
            this.main.jTxtSName.getText().trim().length() < 101 && 
                
            this.main.jTxtFSurname.getText().trim().length() > 0 && 
            this.main.jTxtFSurname.getText().trim().length() < 101 && 
                
            this.main.jTxtSSurname.getText().trim().length() < 101 && 
                
            this.main.jCmbStreet.getSelectedItem().toString().trim().length() < 101 && 
            this.main.jCmbStreet.getSelectedItem().toString().trim().length() > 0 && 
                
            this.main.jTxtAddrNum.getText().trim().length() < 4 && 
            this.main.jTxtAddrNum.getText().trim().length() > 0 && 
                
            this.main.jTxtAddrWard.getText().trim().length() < 101 && 
            this.main.jTxtAddrWard.getText().trim().length() > 0 && 
                
            this.main.jCmbCity.getSelectedItem().toString().trim().length() < 101 && 
            this.main.jCmbCity.getSelectedItem().toString().trim().length() > 0 &&
                
            this.listPhonesModel.size() > 0
                
                )
            try{
                int x = Integer.parseInt(this.main.jTxtDocument.getText().trim());
                int y = Integer.parseInt(this.main.jTxtAddrNum.getText().trim());
                return true;
            }
            catch(Exception e){
                return false;
            }
        return false;
    }
    
    // Método para limpiar el formulario
    private void clearForm(){
        this.main.jTxtDocument.setText("");
        this.main.jTxtFName.setText("");
        this.main.jTxtSName.setText("");
        this.main.jTxtFSurname.setText("");
        this.main.jTxtSSurname.setText("");
        this.main.jCmbStreet.setSelectedIndex(0);
        this.main.jTxtAddrNum.setText("");
        this.main.jTxtAddrWard.setText("");
        this.main.jCmbCity.setSelectedIndex(0);
        this.listPhonesModel.clear();
        this.main.jLstPhones.setModel(this.listPhonesModel);
        this.main.jLbIdCustomer.setText("");
        this.main.jLbIdAddress.setText("");
        this.main.jLbPhone.setText("");
        this.main.jTxtDocument.setEnabled(true);
        this.main.jBtnCustomerSave.setEnabled(true);
        this.main.jBtnCustomerDelete.setEnabled(false);
        this.main.jBtnCustomerEdit.setEnabled(false);
        
        this.loadCustomers();
    }
    
    // Método para cargar los clientes
    private void loadCustomers(){
        this.main.jCmbReportCustomer.removeAllItems();
        this.main.jCmbSaleCustomer.removeAllItems();
        ModelCustomer mdCustomer = new ModelCustomer();
        ArrayList<String> customers = new ArrayList<String>();
        customers = mdCustomer.list();
        for(String customer : customers){
            this.main.jCmbSaleCustomer.addItem(customer);
            this.main.jCmbReportCustomer.addItem(customer);
        }        
    }
    
}
