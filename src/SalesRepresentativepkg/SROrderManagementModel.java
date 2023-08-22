/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesRepresentativepkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anika
 */
public class SROrderManagementModel implements Serializable{
    private final String customerName;
    private final String customerAddress;
    private final int customerNumber;
    private final String packageName;
    private final LocalDate packageValidFrom;
    private final LocalDate packageValidTill;
    private final String teamName;
    private final LocalDate appointmentDate;
    
    public SROrderManagementModel(String customerName, String customerAddress, int customerNumber, String packageName, LocalDate packageValidFrom, LocalDate packageValidTill, String teamName, LocalDate appointmentDate){
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerNumber = customerNumber;
        this.packageName = packageName;
        this.packageValidFrom = packageValidFrom;
        this.packageValidTill = packageValidTill;
        this.teamName = teamName;
        this.appointmentDate = appointmentDate;
    }
    
        public static boolean addNewOrder(String customerName, String customerAddress, int customerNumber, String packageName, LocalDate packageValidFrom, LocalDate packageValidTill, String teamName, LocalDate appointmentDate){
        SROrderManagementModel newOrder = new SROrderManagementModel(customerName, customerAddress, customerNumber, packageName, packageValidFrom, packageValidTill, teamName, appointmentDate);
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("OrderManage.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newOrder);

        } catch (IOException ex) {
            Logger.getLogger(SROrderManagementModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(SROrderManagementModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
        return true;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getPackageName() {
        return packageName;
    }

    public LocalDate getPackageValidFrom() {
        return packageValidFrom;
    }

    public LocalDate getPackageValidTill() {
        return packageValidTill;
    }

    public String getTeamName() {
        return teamName;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void show() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}//kjabdkjnksljlkdcl
