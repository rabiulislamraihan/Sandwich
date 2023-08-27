/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesRepresentativepkg;

import java.io.Serializable;

/**
 *
 * @author anika
 */
public class PackageFeedback implements Serializable{
    public String name;
    public String feedback;
    
    public PackageFeedback(String name, String feedback){
        this.name = name;
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "PackageFeedback{" + "name=" + name + ", feedback=" + feedback + '}';
    }
    
}
