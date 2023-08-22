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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
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
    private TextField expensesTextField;
    @FXML
    private TextField investmentTextField;
    @FXML
    private TextField projectedRevenueTextField;
    @FXML
    private TextField actualRevenueTextField;
    @FXML
    private TextField debtTextField;
    @FXML
    private TableColumn<?, ?> monthColumn;
    @FXML
    private TableColumn<?, ?> budgetColumn;
    @FXML
    private TableColumn<?, ?> expensesColumn;
    @FXML
    private TableColumn<?, ?> investmentsColumn;
    @FXML
    private TableColumn<?, ?> projectedRevenueColumn;
    @FXML
    private TableColumn<?, ?> actualRevenueColumn;
    @FXML
    private TableColumn<?, ?> debtColumn;
    @FXML
    private TableColumn<?, ?> savingsColumn;
    @FXML
    private ComboBox<?> monthCombobox;
    @FXML
    private Label savingsTextField;
    @FXML
    private TextField sa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void budgetingShowChartButtonOnClick(MouseEvent event) {
    }
    
}
