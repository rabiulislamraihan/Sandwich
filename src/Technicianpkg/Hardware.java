/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Technicianpkg;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Hp
 */
public class Hardware implements Serializable{
    protected String name;
    protected int unitCost;
    protected int unitsRemaining;

    public Hardware(String name, int unitCost, int unitsRemaining) {
        this.name = name;
        this.unitCost = unitCost;
        this.unitsRemaining = unitsRemaining;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(int unitCost) {
        this.unitCost = unitCost;
    }

    public int getUnitsRemaining() {
        return unitsRemaining;
    }

    public void setUnitsRemaining(int unitsRemaining) {
        this.unitsRemaining = unitsRemaining;
    }
    


    
    
}
