/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.classes;

/**
 *
 * @author fercho
 */
public class PaymentStrategy {
    private int id;
    private String paymentStrategy;

    public void setId(int id) {
        this.id = id;
    }

    public void setPaymentStrategy(String paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public int getId() {
        return id;
    }

    public String getPaymentStrategy() {
        return paymentStrategy;
    }

    public PaymentStrategy(int id, String paymentStrategy) {
        this.id = id;
        this.paymentStrategy = paymentStrategy;
    }
}
