
package employeepkg;

import java.io.Serializable;
import java.time.LocalDate;
import mainpkg.User;


public class Employee extends User implements Serializable {

    private String Designation;

    public Employee(int ID, String Name, String Address, String ContactNumber, String Email, LocalDate DateOfBirth, LocalDate DateOfJoining, String Password, String Designation) {
        super(ID, Name, Address, ContactNumber, Email, DateOfBirth, DateOfJoining, Password);
        this.Designation = Designation;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }
    
}