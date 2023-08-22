
package Packagepkg;

import employeepkg.Employee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainpkg.AppendableObjectOutputStream;

public class Package implements Serializable {
    private String Title;
    private int Duration;
    private int Price;
    private String Description;
    private String Code;
    private boolean isAvailable;

    public Package(String Title, int Duration, int Price, String Description, String Code, boolean isAvailable) {
        this.Title = Title;
        this.Duration = Duration;
        this.Price = Price;
        this.Description = Description;
        this.Code = Code;
        this.isAvailable = isAvailable;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
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
        if(pkgList.size() == 0) {
            File file = new File("Package.bin");
            file.delete();
        }
        
        for (int i = 0; i < pkgList.size(); i ++) {
            File f = null;
            FileOutputStream fos = null;      
            ObjectOutputStream oos = null;

            try {
                f = new File("Package.bin");
                if(i!=0){
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
        
        for (int i = 0; i < pkgList.size(); i ++) {
            File f = null;
            FileOutputStream fos = null;      
            ObjectOutputStream oos = null;

            try {
                f = new File("Package.bin");
                if(i!=0){
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
    
    
    public static Package getInstance(String Title) {
        ObjectInputStream ois = null;
        Package oc = null;
        try {
             Package c;
             ois = new ObjectInputStream(new FileInputStream("Package.bin"));
             
            while(true){
                c = (Package) ois.readObject();
                if(c.getTitle().equals(Title)) {
                    oc = c;
                    break;
                }
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
        return oc;
        
    }

    
    
    public static boolean checkPackageexistence(Package p) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Package c;
             ois = new ObjectInputStream(new FileInputStream("Package.bin"));
             
            while(true){
                c = (Package) ois.readObject();
                if(c.getCode().equals(p.getCode()) || c.getTitle().equals(p.getTitle())) {
                    result = true;
                }
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
        return result;
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

    
    

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }
    
    
    
}
