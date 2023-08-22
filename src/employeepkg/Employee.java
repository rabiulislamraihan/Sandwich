
package employeepkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainpkg.AppendableObjectOutputStream;


public class Employee implements Serializable {
    private int employeeID;
    private String Name;
    private String Address;
    private String ContactNumber;
    private String Email;
    private LocalDate DateOfBirth;
    private LocalDate DateOfJoining;
    private String Password;
    private String Designation;

    public Employee(int employeeID, String Name, String Address, String ContactNumber, String Email, LocalDate DateOfBirth, LocalDate DateOfJoining, String Password, String Designation) {
        this.employeeID = employeeID;
        this.Name = Name;
        this.Address = Address;
        this.ContactNumber = ContactNumber;
        this.Email = Email;
        this.DateOfBirth = DateOfBirth;
        this.DateOfJoining = DateOfJoining;
        this.Password = Password;
        this.Designation = Designation;
    }

    

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }
    
    
    
    public static int GenerateEmployeeID() {
        int ID_LOWER_BOUND = 1000000;
        int ID_UPPER_BOUND = 9999999;
        Set<Integer> usedIds = new HashSet<>();
        ObjectInputStream ois = null;
        try {
             Employee e;
             ois = new ObjectInputStream(new FileInputStream("Employee.bin"));
             
            while(true){
                e = (Employee) ois.readObject();
                usedIds.add(e.getEmployeeID());
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
    
    
    public static String GenerateEmployeePassword() {
        String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String LOWER = "abcdefghijklmnopqrstuvwxyz";
        String DIGITS = "0123456789";
        String SPECIAL = "!@#$%^&*()_-+=<>?";

        String ALL_CHARACTERS = UPPER + LOWER + DIGITS + SPECIAL;
        int PASSWORD_LENGTH = 12;

        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = random.nextInt(ALL_CHARACTERS.length());
            password.append(ALL_CHARACTERS.charAt(index));
        }
        return password.toString();
    }
    
    public static boolean CheckAccountExistence(int EmployeeID) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Employee c;
             ois = new ObjectInputStream(new FileInputStream("Employee.bin"));
             
            while(true){
                c = (Employee) ois.readObject();
                if(c.getEmployeeID() == EmployeeID) {
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
             Employee c;
             ois = new ObjectInputStream(new FileInputStream("Employee.bin"));
             
            while(true){
                c = (Employee) ois.readObject();
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
    
    
    
    public static boolean passwordMatch(int EmployeeID, String Password) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Employee c;
             ois = new ObjectInputStream(new FileInputStream("Employee.bin"));
             
            while(true){
                c = (Employee) ois.readObject();
                if(c.getEmployeeID() == EmployeeID) {
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
    
    
    public static Employee getInstance(int EmployeeID) {
        ObjectInputStream ois = null;
        Employee oc = null;
        try {
             Employee c;
             ois = new ObjectInputStream(new FileInputStream("Employee.bin"));
             
            while(true){
                c = (Employee) ois.readObject();
                if(c.getEmployeeID() == EmployeeID) {
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
    
    
    public static void CreateNewAccount(Employee c) {
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
        

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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
