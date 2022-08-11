/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.classes;

/**
 *
 * @author fercho
 */
public class ProductSale {
    private int id;
    private double singlePriceValue;
    private int quantity;

    public ProductSale(int id, double singlePriceValue, int quantity) {
        this.id = id;
        this.singlePriceValue = singlePriceValue;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public double getSinglePriceValue() {
        return singlePriceValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSinglePriceValue(double singlePriceValue) {
        this.singlePriceValue = singlePriceValue;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
