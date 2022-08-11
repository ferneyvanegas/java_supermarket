/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package supermarket;

import supermarket.controllers.CtlCategory;
import supermarket.controllers.CtlCustomer;
import supermarket.controllers.CtlDealer;
import supermarket.controllers.CtlProduct;
import supermarket.controllers.CtlSale;
import supermarket.controllers.CtlReport;
import supermarket.views.JFrameMain;

/**
 * @project Supermarket
 * @version 1.0.1
 * @author Ferney Vanegas Hernández
 * @school MinTic - Universidad de Caldas
 * @year 2022
 */
public class Supermarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrameMain jFrameMain = new JFrameMain();
        CtlCustomer ctlCustomer = new CtlCustomer(jFrameMain);
        CtlDealer ctlDealer = new CtlDealer(jFrameMain);
        CtlCategory ctlCategory = new CtlCategory(jFrameMain);
        CtlProduct ctlProduct = new CtlProduct(jFrameMain);
        CtlSale ctlSale = new CtlSale(jFrameMain);
        CtlReport ctlReport = new CtlReport(jFrameMain);
        jFrameMain.setVisible(true);
    }
    
}
