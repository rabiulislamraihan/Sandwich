/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AccountManagerpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sumit
 */
public class BudgetingAndForecastingController implements Initializable {

    @FXML
    private TextField budgetTextField;
    @FXML
    private TextField projectedRevenueTextField;
    @FXML
    private TextField actualRevenueTextField;
    @FXML
    private TableView<?> budgetDataTable;
    @FXML
    private TableColumn<?, ?> budgetMonthColumn;
    @FXML
    private TableColumn<?, ?> budgetColumn;
    @FXML
    private TableColumn<?, ?> projectedRevenueColumn;
    @FXML
    private TableColumn<?, ?> projectedExpensesColumn;
    @FXML
    private ComboBox<?> selectMonthToAddDataCombobox;
    @FXML
    private ComboBox<?> selectMonthToSeePerformanceCombonox;
    @FXML
    private TextField actualExpensesTextField;
    @FXML
    private TextField revenueVarianceTextField;
    @FXML
    private TextField expensesVarianceTextField;
    @FXML
    private TableView<?> performanceDataTable;
    @FXML
    private TableColumn<?, ?> performanceMonthColumn;
    @FXML
    private TableColumn<?, ?> revenueVarianceColumn;
    @FXML
    private TableColumn<?, ?> expensesVarianceColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addBudgetDataButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void viewBudgetDataButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void addPerformanceDataButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void viewPerformanceDataButtonOnClick(MouseEvent event) {
    }
    
}
