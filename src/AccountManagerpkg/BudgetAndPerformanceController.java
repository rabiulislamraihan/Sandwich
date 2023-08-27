/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AccountManagerpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import mainpkg.PDFGenerator;

/**
 * FXML Controller class
 *
 * @author sumit
 */
public class BudgetAndPerformanceController implements Initializable {

    @FXML
    private TextField budgetTextField;
    @FXML
    private TextField projectedRevenueTextField;
    @FXML
    private TextField actualRevenueTextField;
    @FXML
    private ComboBox<String> selectMonthToAddDataCombobox;
    @FXML
    private TextField projectedExpensesTextField;
    @FXML
    private TextField actualExpensesTextField;
    @FXML
    private Label revenueVarianceLabel;
    @FXML
    private Label expensesVarianceLabel;
    @FXML
    private TableView<BudgetAndPerformance> budgetAndPerformanceTable;
    @FXML
    private TableColumn<BudgetAndPerformance, String> monthColumn;
    @FXML
    private TableColumn<BudgetAndPerformance, Double> budgetColumn;
    @FXML
    private TableColumn<BudgetAndPerformance, Double> projectedRevenueColumn;
    @FXML
    private TableColumn<BudgetAndPerformance, Double> projectedExpensesColumn;
    @FXML
    private TableColumn<BudgetAndPerformance, Double> actualRevenueColumn;
    @FXML
    private TableColumn<BudgetAndPerformance, Double> actualExpensesColumn;
    @FXML
    private TableColumn<BudgetAndPerformance, Double> revenueVarianceColumn;
    @FXML
    private TableColumn<BudgetAndPerformance, Double> expensesVarianceColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectMonthToAddDataCombobox.getItems().addAll("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        
        monthColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance, String>("month"));
        budgetColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance, Double>("budget"));
        projectedRevenueColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance,Double>("projectedRevenue"));
        projectedExpensesColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance,Double>("projectedExpenses"));
        actualRevenueColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance,Double>("actualRevenue"));
        actualExpensesColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance,Double>("actualExpenses"));
        expensesVarianceColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance,Double>("expensesVariance"));
        revenueVarianceColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance,Double>("revenueVariance"));
        
        // TODO
    }    

    @FXML
    private void viewDataButtonOnClick(MouseEvent event) {
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("BudgetAndPerformance.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             BudgetAndPerformance F;
            try{
                budgetAndPerformanceTable.getItems().clear();
                while(true){
                    F = (BudgetAndPerformance)ois.readObject();
                    budgetAndPerformanceTable.getItems().add(F);
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch                
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }
    

    @FXML
    private void calculateRevenueVarianceButtonOnClick(MouseEvent event) {
            double projectedRevenue = Double.parseDouble(projectedRevenueTextField.getText());
            double actualRevenue = Double.parseDouble(actualRevenueTextField.getText());

            double revenueVariance = BudgetAndPerformance.calculateRevenueVariance(projectedRevenue, actualRevenue);
            revenueVarianceLabel.setText(String.valueOf(revenueVariance));
        }

    

    @FXML
    private void calculateExpensesVarianceButtonOnClick(MouseEvent event) {
            double projectedExpenses = Double.parseDouble(projectedExpensesTextField.getText());
            double actualExpenses = Double.parseDouble(actualExpensesTextField.getText());

            double expensesVariance = BudgetAndPerformance.calculateExpensesVariance(projectedExpenses, actualExpenses);
            expensesVarianceLabel.setText(String.valueOf(expensesVariance));

    }

    @FXML
    private void addDataButtonOnClick(MouseEvent event) {
        String month = selectMonthToAddDataCombobox.getValue();
        double budget = Double.parseDouble(budgetTextField.getText());
        double projectedRevenue = Double.parseDouble(projectedRevenueTextField.getText());
        double actualRevenue = Double.parseDouble(actualRevenueTextField.getText());
        double projectedExpenses = Double.parseDouble(projectedExpensesTextField.getText());
        double actualExpenses = Double.parseDouble(actualExpensesTextField.getText());
        double revenueVariance = Double.parseDouble(revenueVarianceLabel.getText());
        double expensesVariance = Double.parseDouble(expensesVarianceLabel.getText());

       AccountsManager.addBudgetAndPerformanceData(month, budget, projectedRevenue, actualRevenue, projectedExpenses, actualExpenses, revenueVariance, expensesVariance);

    }

    @FXML
    private void downloadPDFButton(MouseEvent event) {
        BudgetAndPerformance b = budgetAndPerformanceTable.getSelectionModel().getSelectedItem();
        
        PDFGenerator.generatePdf(b.toString());
    }

    
}
