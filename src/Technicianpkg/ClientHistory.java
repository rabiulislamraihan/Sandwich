/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Technicianpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Hp
 */
public class ClientHistory implements Serializable{
    int id;
    String name;
    LocalDate lastservicing;
    String issue;

    public ClientHistory(int id, String name, LocalDate lastservicing, String issue) {
        this.id = id;
        this.name = name;
        this.lastservicing = lastservicing;
        this.issue = issue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLastservicing() {
        return lastservicing;
    }

    public void setLastservicing(LocalDate lastservicing) {
        this.lastservicing = lastservicing;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }


    
    
    
}
