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

/**
 * FXML Controller class
 *
 * @author sumit
 */
public class IncomeStatementController implements Initializable {

    @FXML
    private ComboBox<String> selectMonthCombobox;
    @FXML
    private TextField salaryTextfield;
    @FXML
    private TextField rentTextfield;
    @FXML
    private TextField revenueTextfield;
    @FXML
    private TableView<IncomeStatement> incomeDataTable;
    @FXML
    private TableColumn<IncomeStatement, String> monthColumn;
    @FXML
    private TableColumn<IncomeStatement, Double> revenueColumn;
    @FXML
    private TableColumn<IncomeStatement, Double> expensesColumn;
    @FXML
    private TableColumn<IncomeStatement, Double> netProfitColumn;
    @FXML
    private TableColumn<IncomeStatement, Double> netLossColumn;
    @FXML
    private TextField contentAquisitionTextfield;
    @FXML
    private TextField marketingCostTextfield;
    @FXML
    private Label expensesLabel;
    @FXML
    private Label netProfitLabel;
    @FXML
    private Label netLossLabel;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         selectMonthCombobox.getItems().addAll("January", "February", "March", "April", "May", "June","July", "August", "September", "October", "November", "December");
     
        
        monthColumn.setCellValueFactory(new PropertyValueFactory<IncomeStatement, String>("month"));
        revenueColumn.setCellValueFactory(new PropertyValueFactory<IncomeStatement, Double>("revenue"));
        expensesColumn.setCellValueFactory(new PropertyValueFactory<IncomeStatement, Double>("expenses"));
        netProfitColumn.setCellValueFactory(new PropertyValueFactory<IncomeStatement, Double>("netProfit"));
        netLossColumn.setCellValueFactory(new PropertyValueFactory<IncomeStatement, Double>("netLoss"));

    }    

    
    @FXML
    private void calculateTotalExpensesButton(MouseEvent event) {
        double salaryAndWages = Double.parseDouble(salaryTextfield.getText());
        double rentAndUtilities = Double.parseDouble(rentTextfield.getText());
        double contentAcquisition = Double.parseDouble(contentAquisitionTextfield.getText());
        double marketingCost = Double.parseDouble(marketingCostTextfield.getText());
        

        double totalExpenses = IncomeStatement.calculateTotalExpenses(salaryAndWages, rentAndUtilities, contentAcquisition, marketingCost);

        expensesLabel.setText(String.valueOf(totalExpenses));
    }
    
    @FXML
    private void calculateNetProfitButton(MouseEvent event) {
        double revenue = Double.parseDouble(revenueTextfield.getText());
        double expenses = Double.parseDouble(expensesLabel.getText());
        double netProfit = IncomeStatement.calculateNetProfit(revenue, expenses);
        
        netProfitLabel.setText(String.valueOf(netProfit));

    }

    @FXML
    private void calculateNetLossButton(MouseEvent event) {
        double revenue = Double.parseDouble(revenueTextfield.getText());
        double expenses = Double.parseDouble(expensesLabel.getText());
        double netLoss = IncomeStatement.calculateNetLoss(revenue, expenses);

        netProfitLabel.setText(String.valueOf(netLoss));
        
    }
    
    @FXML
    private void addIncomeDataButton(MouseEvent event) {
        
    String month = selectMonthCombobox.getValue().toString();
    double expenses = Double.parseDouble(expensesLabel.getText());
    double revenue = Double.parseDouble(revenueTextfield.getText());
    double netProfit = IncomeStatement.calculateNetProfit(revenue, expenses);
    double netLoss = IncomeStatement.calculateNetLoss(revenue, expenses);

    double defaultSalaryAndWages = 0.0;
    double defaultRentAndUtilities = 0.0;
    double defaultContentAcquisition = 0.0;
    double defaultMarketingCost = 0.0;
    
    AccountsManager.addIncomeData(month,defaultSalaryAndWages ,defaultRentAndUtilities , expenses, revenue,defaultContentAcquisition , defaultMarketingCost, netProfit, netLoss);
    }
        

    @FXML
    private void viewIncomeDataButton(MouseEvent event) {
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("IncomeData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             IncomeStatement F;
            try{
                while(true){
                    F = (IncomeStatement)ois.readObject();
                    incomeDataTable.getItems().add(F);
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
    private void viewIncomeChartButton(MouseEvent event) {
    }

    
}
