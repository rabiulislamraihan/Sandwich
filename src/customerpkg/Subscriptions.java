
package customerpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainpkg.AppendableObjectOutputStream;


public class Subscriptions implements Serializable {
    private int CustomerID;
    private String PackageID;
    private LocalDate Purchasedate;
    private int price;
    private String Bill;
    private int TransactionID;
    
    public Subscriptions(int CustomerID, String PackageID, LocalDate Purchasedate, int price, String Bill, int TransactionID) {
        this.CustomerID = CustomerID;
        this.PackageID = PackageID;
        this.Purchasedate = Purchasedate;
        this.price = price;
        this.Bill = Bill;
        this.TransactionID = TransactionID;
    }
    
    public static int GenerateTransactionID () {
        int ID_LOWER_BOUND = 1000000;
        int ID_UPPER_BOUND = 9999999;
        Set<Integer> transactionIDs = new HashSet<>();
        ObjectInputStream ois = null;
        try {
             Subscriptions e;
             ois = new ObjectInputStream(new FileInputStream("Subscriptions.bin"));
             
            while(true){
                e = (Subscriptions) ois.readObject();
                transactionIDs.add(e.TransactionID);
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
        Random random = new Random();
        int transactionID;
        do {
            transactionID = ID_LOWER_BOUND + random.nextInt(ID_UPPER_BOUND - ID_LOWER_BOUND);
        } while (transactionIDs.contains(transactionID));
        return transactionID;
    }
    
    
    public static void insertBill(Subscriptions s) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Subscriptions.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(s);

        } catch (IOException ex) {
            Logger.getLogger(Subscriptions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Subscriptions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getBill() {
        return Bill;
    }

    public void setBill(String Bill) {
        this.Bill = Bill;
    }
    
    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getPackageID() {
        return PackageID;
    }

    public void setPackageID(String PackageID) {
        this.PackageID = PackageID;
    }


    public LocalDate getPurchasedate() {
        return Purchasedate;
    }

    public void setPurchasedate(LocalDate Purchasedate) {
        this.Purchasedate = Purchasedate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
}
