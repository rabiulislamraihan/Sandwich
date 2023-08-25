
package employeepkg;

import Administratorpkg.Administrator;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import mainpkg.Account;
import mainpkg.PopUp;

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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MonthColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("Month"));
        YearColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("Year"));
        BaseSalaryColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("BaseSalary"));
        BonusColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("Bonus"));
        OvertimePayColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("OvertimePay"));
        PerformanceBasedPayColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("PerformanceBasedPay"));
        TotalColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("TotalPay"));

    }    


    @FXML
    private void SeeSalaryDetailsOnClick(MouseEvent event) {
        int id = Integer.parseInt(employeeIDTextField.getText());
        if (Account.CheckEmployeeAccountExistence(id) == false) {
            PopUp.Message("Employee Not Found !");
            return;
        }
        tableView.getItems().addAll(Administrator.getSalaryList());
    }
}
