/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SalesRepresentativepkg;

import ContentManagerpkg.Schedule;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import Packagepkg.Package;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author anika
 */
public class SrManageOrdersController implements Initializable {

    @FXML
    private TextField srOMcustomerName;
    @FXML
    private TextField srOMcustomerAddress;
    @FXML
    private TextField srOMcustomerNo;
    @FXML
    private ComboBox<String> srOMpackageName;
    @FXML
    private DatePicker srOMappointmentDate;
    @FXML
    private ComboBox<String> srOMit;
    @FXML
    private TextArea srOMshow;
    @FXML
    private TextField duration;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        srOMit.getItems().addAll("Team 1","Team 2", "Team 3", "Team 4","Team 5");
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Package c;
             ois = new ObjectInputStream(new FileInputStream("Package.bin"));
             
            while(true){
                c = (Package) ois.readObject();
                srOMpackageName.getItems().add(c.getTitle());
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
    }    

    @FXML
    private void srOMplaceOrder(MouseEvent event) {
        Boolean orderStatus = SROrderManagementModel.addNewOrder(
         srOMcustomerName.getText(),srOMcustomerAddress.getText(),Integer.parseInt(srOMcustomerNo.getText()),srOMpackageName.getValue(), Integer.parseInt(duration.getText())
                 ,srOMit.getValue(),srOMappointmentDate.getValue()
     );
    if (orderStatus==true){
        srOMshow.setText("");
        ObjectInputStream ois = null;
        File f = null;
        FileInputStream fis = null;      
        
        try {
            f = new File("OrderManage.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            SROrderManagementModel order;
            try{
                srOMshow.setText("");
                while(true){
                    System.out.println("Printing objects.");
                    order = (SROrderManagementModel)ois.readObject();
                    System.out.println(order.toString());
                    srOMshow.appendText("Customer Name: " + order.getCustomerName() + "\n" +
                            "Customer Address: " + order.getCustomerAddress() + "\n" +
                            "Customer Phone no.: " + order.getCustomerNumber() + "\n" +
                            "Package ID: " + order.getPackageName() + "\n" +
                            "Duration: " + order.getDuration()+ "\n" +
                            "Installation Team: " + order.getTeamName() + "\n" +
                            "Appointment Date: " + order.getAppointmentDate() + "\n"
                    );
                }
            }
            catch(Exception e){
            }                
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        } 
    }else{
        srOMshow.setText("Something went wrong");
    }
    }

    @FXML
    private void packageNameOnClick(ActionEvent event) {
        ObjectInputStream ois = null;
        try{
            Package s;
            ois = new ObjectInputStream(new FileInputStream("Package.bin"));
            
            while(true){
                s = (Package) ois.readObject();
                if(s.getTitle().equals(srOMpackageName.getValue())){
                    duration.setText(Integer.toString(s.getDuration()));
                }
                
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            try {
                if(ois!=null){
                    ois.close();
                }
            }
            catch (IOException ex1){ }
        }
    }
}
