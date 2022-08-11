/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.classes;

import java.util.ArrayList;

import supermarket.classes.Address;

/**
 *
 * @author fercho
 */
public class Customer {
    private int id;
    private String document;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private Address address;
    private ArrayList<String> phones;

    public Customer(String document, String firstName, String secondName, 
            String firstSurname, String secondSurname, Address address) {
        this.id = 0;
        this.document = document;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.address = address;
        
        this.phones = new ArrayList<String>();
    }
    
    public Customer(String document, String firstName, String secondName, 
            String firstSurname, String secondSurname, Address address, ArrayList<String> phones) {
        this.id = 0;
        this.document = document;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.address = address;
        
        this.phones = phones;
    }

    public int getId() {
        return id;
    }

    public String getDocument() {
        return document;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public Address getAddress() {
        return this.address;
    }
    
    public String getPhone(int index){
        return this.phones.get(index);
    }

    public ArrayList<String> getPhones() {
        return phones;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(String newPhone) {
        this.phones.add(newPhone);
    }
    
    
    
}
