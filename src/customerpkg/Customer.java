
package customerpkg;

import java.io.Serializable;
import java.time.LocalDate;
import mainpkg.User;


public class Customer extends User implements Serializable {

    public Customer(int ID, String Name, String Address, String ContactNumber, String Email, LocalDate DateOfBirth, String Password) {
        super(ID, Name, Address, ContactNumber, Email, DateOfBirth, LocalDate.now(), Password);
    }
}