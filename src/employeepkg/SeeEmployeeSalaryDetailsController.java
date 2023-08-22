/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package employeepkg;

import Administratorpkg.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class SeeEmployeeSalaryDetailsController implements Initializable {

    @FXML
    private TextField employeeIDTextField;
    @FXML
    private TableView<Salary> tableView;
    @FXML
    private TableColumn<Salary, String> MonthColumn;
    @FXML
    private TableColumn<Salary, Integer> YearColumn;
    @FXML
    private TableColumn<Salary, Integer> BaseSalaryColumn;
    @FXML
    private TableColumn<Salary, Integer> BonusColumn;
    @FXML
    private TableColumn<Salary, Integer> OvertimePayColumn;
    @FXML
    private TableColumn<Salary, Integer> PerformanceBasedPayColumn;
    @FXML
    private TableColumn<Salary, Integer> TotalColumn;

    /**
     * Initializes the controller class.
     */
//    rivate String Month;
//    private int Year;
//    private int EmployeeID;
//    private int BaseSalary;
//    private int Bonus;
//    private int OvertimePay;
//    private int PerformanceBasedPay;
//    private int TotalPay;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MonthColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("Month"));
        YearColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("Year"));
        BaseSalaryColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("BaseSalary"));
        BonusColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("Bonus"));
        OvertimePayColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("OvertimePay"));
        PerformanceBasedPayColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("PerformanceBasedPay"));
        TotalColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("TotalPay"));

        // TODO
    }    


    @FXML
    private void SeeSalaryDetailsOnClick(MouseEvent event) {
        int id = Integer.parseInt(employeeIDTextField.getText());
        if (Employee.CheckAccountExistence(id) == false) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Employee Not Found !");
            a.showAndWait();
            return;
        }
        
        ObjectInputStream ois = null;
        Employee oc = null;
        try {
             Salary c;
             ois = new ObjectInputStream(new FileInputStream("Salary.bin"));
             
            while(true){
                c = (Salary) ois.readObject();
                if(c.getEmployeeID() == id) {
                    tableView.getItems().add(c);
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
    }
    
}
