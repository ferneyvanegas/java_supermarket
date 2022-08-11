/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.classes;

import java.sql.Date;

/**
 *
 * @author fercho
 */
public class Sale {
    private int id;
    private Date date;
    private double discount;
    private double totalValue;
    private int idCustomer;
    private int idPayment;

    public Sale(Date date, double discount, double totalValue, int idCustomer, int idPayment) {
        this.id = 0;
        this.date = date;
        this.discount = discount;
        this.totalValue = totalValue;
        this.idCustomer = idCustomer;
        this.idPayment = idPayment;
    }
    
    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public int getIdPayment() {
        return idPayment;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }
    
    
    
}
