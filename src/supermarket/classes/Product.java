/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.classes;

import java.util.ArrayList;

/**
 *
 * @author fercho
 */
public class Product {
    private int id;
    private String productName;
    private double price;
    private boolean stock;
    private int idCategory;
    private ArrayList<String> dealers;

    public Product(String productName, double price, boolean stock, int idCategory) {
        this.id = 0;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.idCategory = idCategory;
        this.dealers = new ArrayList<String>();
    }
    
    public Product(String productName, double price, boolean stock, int idCategory, ArrayList<String> dealers) {
        this.id = 0;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.idCategory = idCategory;
        this.dealers = dealers;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStock() {
        return stock;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public ArrayList<String> getDealers() {
        return dealers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public void setDealers(ArrayList<String> dealers) {
        this.dealers = dealers;
    }    
}
