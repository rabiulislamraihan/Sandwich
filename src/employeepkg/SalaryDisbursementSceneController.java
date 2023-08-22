
package employeepkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class SalaryDisbursementSceneController implements Initializable {

    @FXML
    private TextField salaryTextField;
    @FXML
    private TextField BonusTextField;
    @FXML
    private TextField OverTimePayTextField;
    @FXML
    private TextField PerformanceBasedPayTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private Label totalSalaryLabel;
    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private TextField employeeTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        monthComboBox.getItems().addAll(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December");
    }    

    @FXML
    private void CalculateTotalSalaryOnClick(MouseEvent event) {
        int baseSalary = Integer.parseInt(salaryTextField.getText());
        int bonus = Integer.parseInt(BonusTextField.getText());
        int overtimepay = Integer.parseInt(OverTimePayTextField.getText());
        int performancebasedsalary = Integer.parseInt(PerformanceBasedPayTextField.getText());
        int total = baseSalary + bonus + overtimepay + performancebasedsalary;
        totalSalaryLabel.setText(Integer.toString(total));
        
    }

    @FXML
    private void PaySalaryOnClick(MouseEvent event) {
        int id = Integer.parseInt(employeeTextField.getText());
        if (!Employee.CheckAccountExistence(id)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Employee Doesn't Exist !");
            a.showAndWait();
        }
        else {
            String month = monthComboBox.getValue();
            int year = Integer.parseInt(yearTextField.getText());
            int baseSalary = Integer.parseInt(salaryTextField.getText());
            int bonus = Integer.parseInt(BonusTextField.getText());
            int overtimepay = Integer.parseInt(OverTimePayTextField.getText());
            int performancebasedsalary = Integer.parseInt(PerformanceBasedPayTextField.getText());
            Salary s = new Salary(month, year, id, baseSalary, bonus, overtimepay, performancebasedsalary);
            Employee.PaySalary(s);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Salary has been paid !");
            a.showAndWait();
        }
    }
    
}
