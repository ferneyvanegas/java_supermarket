/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.classes;

/**
 *
 * @author fercho
 */
public class Payment {
    private int id;
    private double persentageInterest;

    public Payment(int id, double persentageInterest) {
        this.id = id;
        this.persentageInterest = persentageInterest;
    }

    public int getId() {
        return id;
    }

    public double getPersentageInterest() {
        return persentageInterest;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersentageInterest(double persentageInterest) {
        this.persentageInterest = persentageInterest;
    }
    
    
}
