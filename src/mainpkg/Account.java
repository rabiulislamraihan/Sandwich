
package mainpkg;

import customerpkg.Customer;
import employeepkg.Employee;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public interface Account {
    
    
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
    
    
    public static boolean CheckEmployeeAccountExistence(int EmployeeID) {
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
    
    
    public static boolean CheckEmployeeAccountExistence(String Email) {
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
    
    
    public static boolean EmployeepasswordMatch(int EmployeeID, String Password) {
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
    
    public static Employee getEmployeeInstance(int EmployeeID) {
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
    
    
    public static boolean CheckCustomerAccountExistence(int CustomerID) {
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
    
    public static boolean CheckCustomerAccountExistence(String Email) {
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
    
    
    public static boolean CustomerpasswordMatch(int CustomerID, String Password) {
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
    
    
    public static Customer getCustomerInstance(int CustomerID) {
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
    
}
