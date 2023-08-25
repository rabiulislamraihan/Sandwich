
package customerpkg;

import java.io.Serializable;
import java.time.LocalDate;


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
