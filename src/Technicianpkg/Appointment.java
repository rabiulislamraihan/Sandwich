/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Technicianpkg;

import customerpkg.Customer;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Hp
 */
public class Appointment implements Serializable {
    Customer c;
    String name;
    int id;
    String address;
    LocalDate time;
    boolean status;

    public Appointment(Customer c, LocalDate time, boolean status) {
        this.c = c;
        this.name = c.getName();
        this.address = c.getAddress();
        this.id = c.getCustomerID();
        this.time = time;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
