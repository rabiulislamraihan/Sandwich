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
public class Bill implements Serializable {
    int id;
    String Client;
    String time;
    float EquipmentCharge;
    float SericeCharge;
    float discount;
    float total;
    float GrandTotal;

    public Bill(int id, String Client, String timeStamp, float EquipmentCharge, float SericeCharge, float discount, float total, float GrandTotal) {
        this.id = id;
        this.Client = Client;
        this.time = timeStamp;
        this.EquipmentCharge = EquipmentCharge;
        this.SericeCharge = SericeCharge;
        this.discount = discount;
        this.total = total;
        this.GrandTotal = GrandTotal;
    }    
    public static float CalculateTotal(float equipmentCharge,float serviceCharge, float discount){
        return(equipmentCharge + serviceCharge - discount);
    }
    
    
    public static float CalculateGrandTotal(float total, float tax){
        return total+tax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
//  

    public String getClient() {
        return Client;
    }

    public void setClient(String Client) {
        this.Client = Client;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getEquipmentCharge() {
        return EquipmentCharge;
    }

    public void setEquipmentCharge(float EquipmentCharge) {
        this.EquipmentCharge = EquipmentCharge;
    }

    public float getSericeCharge() {
        return SericeCharge;
    }

    public void setSericeCharge(float SericeCharge) {
        this.SericeCharge = SericeCharge;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getGrandTotal() {
        return GrandTotal;
    }

    public void setGrandTotal(float GrandTotal) {
        this.GrandTotal = GrandTotal;
    }
    
}
