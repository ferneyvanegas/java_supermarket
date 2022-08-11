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
import supermarket.models.ModelReport;

import supermarket.views.JFrameMain;

/**
 *
 * @author fercho
 */
public class CtlReport implements ActionListener {
    private JFrameMain main;

    public CtlReport(JFrameMain jFrameMain) {
        this.main = jFrameMain;
        
        this.main.jBtnReportCheck.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==this.main.jBtnReportCheck){
            if(this.main.jCmbReportCustomer.getItemCount() > 0){
                String customer = this.main.jCmbReportCustomer.getSelectedItem().toString().trim();
                int idCustomer = Integer.parseInt(customer.substring(0, customer.indexOf(":")));
                ModelReport mdReport = new ModelReport();
                ArrayList<String> regs = new ArrayList<String>();
                try{
                    regs = mdReport.listProductByCustomer(idCustomer);
                    DefaultListModel listModel = new DefaultListModel(); 
                    if(regs.size() < 1){
                        JOptionPane.showMessageDialog(null, "No se encontraron ventas para este cliente", "Atención", 2);
                    }
                    else{   
                        for(String reg: regs){
                            listModel.addElement(reg);
                        }             
                    }
                    this.main.jListReportSales.setModel(listModel);
                }
                catch(Exception e){
                    System.out.println("Error: " + e);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Escoge un usuario", "Cuidado", 0);
            }
        }
    }  
    
}
