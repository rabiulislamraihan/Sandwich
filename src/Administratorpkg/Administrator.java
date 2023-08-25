package Administratorpkg;

import customerpkg.Customer;
import employeepkg.Employee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import mainpkg.AppendableObjectOutputStream;
import Packagepkg.Package;
import customerpkg.Subscriptions;
import employeepkg.Salary;
import java.util.ArrayList;

public interface Administrator {
    
    
    public static void EmployeeCreateNewAccount(Employee c) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Employee.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(c);

        } catch (IOException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static void CustomerCreateNewAccount(Customer c) {
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Customer.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(c);

        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static ObservableList <Customer> getCustomerList() {
        ObjectInputStream ois = null;
        ObservableList <Customer> list = FXCollections.observableArrayList();
        try {
             Customer c;
             ois = new ObjectInputStream(new FileInputStream("Customer.bin"));
             
            while(true){
                c = (Customer) ois.readObject();
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
    
    
    
    public static void AddNewPackage(Package p) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Package.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(p);

        } catch (IOException ex) {
            Logger.getLogger(Package.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Package.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static void UpdatePrice(Package p, int newPrice) {
        ArrayList <Package> pkgList = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
             Package c;
             ois = new ObjectInputStream(new FileInputStream("Package.bin"));
             
            while(true){
                c = (Package) ois.readObject();
                if(c.getCode().equals(p.getCode())) c.setPrice(newPrice);
                pkgList.add(c);
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
        
        File file = new File("Package.bin");
        file.delete();
        
        for (int i = 0; i < pkgList.size(); i ++) {
            File f = null;
            FileOutputStream fos = null;      
            ObjectOutputStream oos = null;

            try {
                f = new File("Package.bin");
                if(f.exists()){
                    fos = new FileOutputStream(f,true);
                    oos = new AppendableObjectOutputStream(fos);                
                }
                else{
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);               
                }
                oos.writeObject(pkgList.get(i));

            } catch (IOException ex) {
                Logger.getLogger(Package.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(oos != null) oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Package.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    
    public static void deleteItem(Package p) {
        ArrayList <Package> pkgList = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
             Package c;
             ois = new ObjectInputStream(new FileInputStream("Package.bin"));
             
            while(true){
                c = (Package) ois.readObject();
                if(!c.getTitle().equals(p.getTitle())) pkgList.add(c);
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
        File file = new File("Package.bin");
        file.delete();
        
        for (int i = 0; i < pkgList.size(); i ++) {
            File f = null;
            FileOutputStream fos = null;      
            ObjectOutputStream oos = null;

            try {
                f = new File("Package.bin");
                if(f.exists()){
                    fos = new FileOutputStream(f,true);
                    oos = new AppendableObjectOutputStream(fos);                
                }
                else{
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);               
                }
                oos.writeObject(pkgList.get(i));

            } catch (IOException ex) {
                Logger.getLogger(Package.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(oos != null) oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Package.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static ArrayList <Subscriptions> getSubscriptionList() {
        ArrayList <Subscriptions> list = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
             Subscriptions c;
             ois = new ObjectInputStream(new FileInputStream("Subscriptions.bin"));
             
            while(true){
                c = (Subscriptions) ois.readObject();
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
    public static ObservableList <Package> getPackagelist() {
        ObservableList <Package> list = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Package c;
             ois = new ObjectInputStream(new FileInputStream("Package.bin"));
             
            while(true){
                c = (Package) ois.readObject();
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
    
    public static void PaySalary(Salary c) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Salary.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(c);

        } catch (IOException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static ObservableList <Salary> getSalaryList() {
        ObservableList <Salary> list = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        try {
             Salary c;
             ois = new ObjectInputStream(new FileInputStream("Salary.bin"));
             
            while(true){
                c = (Salary) ois.readObject();
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
