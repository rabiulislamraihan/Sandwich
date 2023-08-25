/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Technicianpkg;

import java.io.Serializable;

/**
 *
 * @author Hp
 */
public class Report implements Serializable{
    String subject;
    String text;

    public Report(String subject, String text) {
        this.subject = subject;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Report{" + "subject= " + subject + ", text= " + text + '}';
    }
           
}
