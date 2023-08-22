/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Technicianpkg;

import com.sun.scenario.effect.ImageData;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Cell;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javax.swing.text.Document;
import javax.swing.text.StyleConstants.FontConstants;
import mainpkg.PDFGenerator;






/**
 *
 * @author Hp
 */
public class Technician implements Serializable{
    
    
    public static void AddHardware(String name, int cost, int units){
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Hardware.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            Hardware h = new Hardware(name, cost, units);  
            oos.writeObject(h);
            

        } catch (IOException ex) {
            Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        
        
        
    }
    public static Hardware UpdateHardware(String updateItem, String updateCatagory, String newData){
        
         ObjectInputStream ois = null;
         File s;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try{
            Hardware h;
            ois = new ObjectInputStream(new FileInputStream("Report.bin"));
            s = new File("Report.bin");
            if(s.exists()){
                fos = new FileOutputStream(s,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(s);
                oos = new ObjectOutputStream(fos);               
            }
            
            
            while(true){
                h = (Hardware) ois.readObject();
                if(h.name.equals(updateItem)){
                    
                   if(updateCatagory.equals("Unit Price")){
                       h.setUnitCost(Integer.parseInt(newData)); 
                        oos.writeObject(h);
                        
                       
                   }
                   else if(updateCatagory.equals("Units Left")){
                       h.setUnitsRemaining(Integer.parseInt(newData));
                        oos.writeObject(h);
                       
                   }
                   return h;
                }
              
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            try {
                if(ois!=null){
                    ois.close();
                }
            }
            catch (IOException ex1){ }
        }
       

    return null;
        
        
    }
  
    
       
        public static void CreateBill(int id,String name, String timeStamp, float equipmentCharge, float serviceCharge, float discount, float total, float grandTotal){
            
           
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Bill.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
              Bill newBill = new Bill(id, name, timeStamp, equipmentCharge, serviceCharge, discount, total, grandTotal);  
            
            oos.writeObject(newBill);

        } catch (IOException ex) {
            Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
            
        }
        
        public static void generatePDF(String text){
           
            PDFGenerator.generatePdf(text);
            
        }
        
        
        public static void CreateReport(String subject, String text){
            
            
        File s = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

       
        
        try {
            s = new File("Report.bin");
            if(s.exists()){
                fos = new FileOutputStream(s,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(s);
                oos = new ObjectOutputStream(fos);               
            }
            
            
            Report newReport = new Report(subject, text);    
//            listOfReport.add(newReport);
           oos.writeObject(newReport);
//           oos.close();
           
            

        } catch (IOException ex) {
            Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
        }
        
        public static String SearchReport(String subject) throws IOException{

        ObjectInputStream ois = null;

        try{
            Report r;
            ois = new ObjectInputStream(new FileInputStream("Report.bin"));
            
            while(true){
                r = (Report) ois.readObject();
                if(r.subject.equals(subject)){
                    return r.text;
                }
                
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            try {
                if(ois!=null){
                    ois.close();
                }
            }
            catch (IOException ex1){ }
        }
        return null;
        
    
        }
    public static String AddClientHistory(int id, String name, LocalDate lastservicing, String issue) throws ClassNotFoundException{
        
         File s = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

     
        try {
            ClientHistory h;
            s = new File("ClientHistory.bin");
            if(s.exists()){
                fos = new FileOutputStream(s,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(s);
                oos = new ObjectOutputStream(fos);               
            }
            
            ClientHistory ch = new ClientHistory(id, name, lastservicing, issue);    
//            listOfReport.add(newReport);
           oos.writeObject(ch);
            
//           oos.close();
           
            

        } catch (IOException ex) {
            Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    
  return null;
   }
    
   public static String LookupClientHistory(int id){
       
        ObjectInputStream ois = null;
        String data = null;
        try{
            ClientHistory ch;
            ois = new ObjectInputStream(new FileInputStream("ClientHistory.bin"));
            
            while(true){
                ch = (ClientHistory) ois.readObject();
                if(ch.getId()==(id)){
                    data = data+ ch.name + "\n" + ch.lastservicing + "\n" + ch.getIssue() + "\n \n";
                }
                
            }
            
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            try {
                if(ois!=null){
                    ois.close();
                }
            }
            catch (IOException ex1){ }
        }
        return data;
        
        
       
   }
    
    
    
    
}