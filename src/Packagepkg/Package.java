
package Packagepkg;
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
    private final String Code;
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
}
