/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AccountManagerpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class FinancialReportingController implements Initializable {

    @FXML
    private TableView<FinancialData> financialDataTable;
    @FXML
    private TableColumn<FinancialData, String> finacialDataColumnMonth;
    @FXML
    private TableColumn<FinancialData, Double> finacialDataColumnRevenue;
    @FXML
    private TableColumn<FinancialData, Double> finacialDataColumnExpenses;
    @FXML
    private TableColumn<FinancialData, Double> finacialDataColumnProfit;
    @FXML
    private TableColumn<FinancialData, Double> finacialDataColumnCustomerAcquisition;
    @FXML
    private TableColumn<FinancialData, Double> finacialDataColumnCustomerChurn;
    @FXML
    private TableColumn<FinancialData, Double> finacialDataColumnLoss;
    
    
    @FXML
    private Label profitLabel;
    @FXML
    private Label lossLabel;
    @FXML
    private TextField revenueTextField;
    @FXML
    private TextField expensesTextField;
    @FXML
    private TextField customerAcquisitionTextField;
    @FXML
    private TextField customerChurnTextField;
    @FXML
    private ComboBox<String> financialDataMonthCombobox;
    
   
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         financialDataMonthCombobox.getItems().addAll("January", "February", "March");
        
        
        finacialDataColumnMonth.setCellValueFactory(new PropertyValueFactory<FinancialData, String> ("month"));
        finacialDataColumnExpenses.setCellValueFactory(new PropertyValueFactory<FinancialData, Double> ("expenses"));
        finacialDataColumnRevenue.setCellValueFactory(new PropertyValueFactory<FinancialData, Double> ("revenue"));
        finacialDataColumnProfit.setCellValueFactory(new PropertyValueFactory<FinancialData, Double> ("profit"));
        finacialDataColumnLoss.setCellValueFactory(new PropertyValueFactory<FinancialData, Double> ("loss"));
        finacialDataColumnCustomerAcquisition.setCellValueFactory(new PropertyValueFactory<FinancialData, Double> ("customerAcquisition"));
        finacialDataColumnCustomerChurn.setCellValueFactory(new PropertyValueFactory<FinancialData, Double> ("customerChurn"));
        
        
        // TODO
    }    

    @FXML
    private void addFinancialDataButtonOnClick(MouseEvent event) {
        
          
          String MONTH = financialDataMonthCombobox.getValue();         
          double EXPENSES = Double.parseDouble(expensesTextField.getText());
          double REVENUE = Double.parseDouble(revenueTextField.getText());
          double CUSTOMERACQUISITION = Double.parseDouble( customerAcquisitionTextField.getText());
          double CUSTOMERCHURN = Double.parseDouble(customerChurnTextField.getText());
          double PROFIT = FinancialData.calculateProfit(REVENUE, EXPENSES);
          double LOSS = FinancialData.calculateLoss(REVENUE, EXPENSES);
          
          
          AccountsManager.CreateFinancialData(MONTH, EXPENSES, REVENUE, PROFIT, LOSS, CUSTOMERACQUISITION, CUSTOMERCHURN);
                   
    }

    @FXML
    private void displayFinancialDataButtonOnClick(MouseEvent event) {
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("FinancialData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             FinancialData F;
            try{
                while(true){
                    F = (FinancialData)ois.readObject();
                    financialDataTable.getItems().add(F);
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
    private void caculateProfitButtonOnClick(MouseEvent event) {
        double expenses = Double.parseDouble(expensesTextField.getText());
        double revenue = Double.parseDouble(revenueTextField.getText());
        double profit = FinancialData.calculateProfit(revenue, expenses);

        
        profitLabel.setText("Profit: " + profit);
    }

    @FXML
    private void caculateLossButtonOnClick(MouseEvent event) {
        double expenses = Double.parseDouble(expensesTextField.getText());
        double revenue = Double.parseDouble(revenueTextField.getText());
        double loss = FinancialData.calculateLoss(revenue, expenses);

     
        lossLabel.setText("Loss: " + loss);

    
    }
}
    
