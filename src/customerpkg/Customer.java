
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


public class Customer implements Serializable {
    private int customerID;
    private String Name;
    private String Address;
    private String ContactNumber;
    private String Email;
    private LocalDate DateOfBirth;
    private LocalDate DateOfJoining;
    private String Password;

    public Customer(int customerID, String Name, String Address, String ContactNumber, String Email, LocalDate DateOfBirth, String Password) {
        this.customerID = customerID;
        this.Name = Name;
        this.Address = Address;
        this.ContactNumber = ContactNumber;
        this.Email = Email;
        this.DateOfBirth = DateOfBirth;
        this.DateOfJoining = LocalDate.now();
        this.Password = Password;
    }
    
    public static int GenerateCustomerID() {
        int ID_LOWER_BOUND = 1000000;
        int ID_UPPER_BOUND = 9999999;
        Set<Integer> usedIds = new HashSet<>();
        ObjectInputStream ois = null;
        try {
             Customer e;
             ois = new ObjectInputStream(new FileInputStream("Customer.bin"));
             
            while(true){
                e = (Customer) ois.readObject();
                usedIds.add(e.getCustomerID());
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
        int id;
        do {
            id = ID_LOWER_BOUND + random.nextInt(ID_UPPER_BOUND - ID_LOWER_BOUND);
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;
    }
    
    
    public static boolean CheckAccountExistence(int CustomerID) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Customer c;
             ois = new ObjectInputStream(new FileInputStream("Customer.bin"));
             
            while(true){
                c = (Customer) ois.readObject();
                if(c.getCustomerID() == CustomerID) {
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
    
    
    public static boolean CheckAccountExistence(String Email) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Customer c;
             ois = new ObjectInputStream(new FileInputStream("Customer.bin"));
             
            while(true){
                c = (Customer) ois.readObject();
                if(c.getEmail().equals(Email)) {
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
    
    
    
    public static boolean passwordMatch(int CustomerID, String Password) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Customer c;
             ois = new ObjectInputStream(new FileInputStream("Customer.bin"));
             
            while(true){
                c = (Customer) ois.readObject();
                if(c.getCustomerID() == CustomerID) {
                    if(c.getPassword().equals(Password)) {
                        result = true;
                    }
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
    
    
    public static Customer getInstance(int CustomerID) {
        ObjectInputStream ois = null;
        Customer oc = null;
        try {
             Customer c;
             ois = new ObjectInputStream(new FileInputStream("Customer.bin"));
             
            while(true){
                c = (Customer) ois.readObject();
                if(c.getCustomerID() == CustomerID) {
                    oc = c;
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
    
    
    public static void CreateNewAccount(Customer c) {
        
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
  


    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public LocalDate getDateOfJoining() {
        return DateOfJoining;
    }

    public void setDateOfJoining(LocalDate DateOfJoining) {
        this.DateOfJoining = DateOfJoining;
    }
}
