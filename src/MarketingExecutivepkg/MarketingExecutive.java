/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MarketingExecutivepkg;

import AccountManagerpkg.BudgetAndPerformance;
import AccountManagerpkg.IncomeStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.AppendableObjectOutputStream;

/**
 *
 * @author sumit
 */
public class MarketingExecutive implements Serializable{
    
    public static String getvision() {
        
        ObjectInputStream ois = null;
        String vision = null;
        try {
             BrandVisionAndGuidelines c;
             ois = new ObjectInputStream(new FileInputStream("BrandVisionAndGuidelines.bin"));
            while(true){
                c = (BrandVisionAndGuidelines) ois.readObject();
                    vision = c.getVision();
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return vision;
    }
    
    public static String getguidelines() {
        
        ObjectInputStream ois = null;
        String guidelines = null;
        try {
             BrandVisionAndGuidelines c;
             ois = new ObjectInputStream(new FileInputStream("BrandVisionAndGuidelines.bin"));
            while(true){
                c = (BrandVisionAndGuidelines) ois.readObject();
                    guidelines = c.getGuidelines();
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return guidelines;
    }
    
    public static void updateBrandVision(String vision) {
        
        ObjectInputStream ois = null;
        String guidelines = null;
        try {
             BrandVisionAndGuidelines c;
             ois = new ObjectInputStream(new FileInputStream("BrandVisionAndGuidelines.bin"));
            while(true){
                c = (BrandVisionAndGuidelines) ois.readObject();
                    guidelines = c.getGuidelines();
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        BrandVisionAndGuidelines bg = new BrandVisionAndGuidelines(vision, guidelines);
        File file = new File("BrandVisionAndGuidelines.bin");
        file.delete();
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("BrandVisionAndGuidelines.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(bg);
        } catch (IOException ex) {
            // Handle exceptions
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException ex) {
                // Handle exceptions
            }
        }
    }
    
    public static void updateBrandGuidelines(String guidelines) {
        
        ObjectInputStream ois = null;
        String vision = null;
        try {
             BrandVisionAndGuidelines c;
             ois = new ObjectInputStream(new FileInputStream("BrandVisionAndGuidelines.bin"));
            while(true){
                c = (BrandVisionAndGuidelines) ois.readObject();
                    vision = c.getVision();
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        BrandVisionAndGuidelines bg = new BrandVisionAndGuidelines(vision, guidelines);
        File file = new File("BrandVisionAndGuidelines.bin");
        file.delete();
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("BrandVisionAndGuidelines.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(bg);
        } catch (IOException ex) {
            // Handle exceptions
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException ex) {
                // Handle exceptions
            }
        }
    }
    
    public static void addCampaign(DesignCampaign dp){
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("DesignCampaign.bin"); // Adjust the file name as needed
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(dp);

        } catch (IOException ex) {
            // Handle exceptions
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException ex) {
                // Handle exceptions
            }
        }

        }
    
    
   public static ObservableList<DesignCampaign> getCampaignList() {
       ObservableList<DesignCampaign> list = FXCollections.observableArrayList();
       ObjectInputStream ois = null;
        try {
             DesignCampaign c;
             ois = new ObjectInputStream(new FileInputStream("DesignCampaign.bin"));
            while(true){
                c = (DesignCampaign) ois.readObject();
                    list.add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return list;
   }
   
   public static void addCampaignReport(CampaignReport cr){
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("CampaignReport.bin"); // Adjust the file name as needed
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(cr);

        } catch (IOException ex) {
            // Handle exceptions
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException ex) {
                // Handle exceptions
            }
        }

    }
   
   public static ObservableList<CampaignReport> getCampaignReportList() {
       ObservableList<CampaignReport> list = FXCollections.observableArrayList();
       ObjectInputStream ois = null;
        try {
             CampaignReport c;
             ois = new ObjectInputStream(new FileInputStream("CampaignReport.bin"));
            while(true){
                c = (CampaignReport) ois.readObject();
                    list.add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return list;
        
        
   }
   
   
         
         
}
