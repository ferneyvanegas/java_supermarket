/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.classes;

import supermarket.classes.Address;

/**
 *
 * @author fercho
 */
public class Dealer {
    private int id;
    private String nit;
    private String registeredName;
    private String email;
    private String legalAgent;
    private String webSite;
    private Address address;

    public Dealer(String nit, String registeredName, String email, String legalAgent, String webSite, Address address) {
        this.id = id;
        this.nit = nit;
        this.registeredName = registeredName;
        this.email = email;
        this.legalAgent = legalAgent;
        this.webSite = webSite;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getNit() {
        return nit;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public String getEmail() {
        return email;
    }

    public String getLegalAgent() {
        return legalAgent;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Address getAddress() {
        return this.address;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLegalAgent(String legalAgent) {
        this.legalAgent = legalAgent;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
}
