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
public class TaxManagementController implements Initializable {

    @FXML
    private TextField deductionTextfield;
    @FXML
    private Label totalTaxLabel;
    @FXML
    private ComboBox<String> monthCombobox;
    @FXML
    private TextField taxPercentageTextfield;
    @FXML
    private Label taxableIncomeLabel;
    @FXML
    private TableView<TaxData> taxDataTable;
    @FXML
    private TableColumn<TaxData, String> monthColumn;
    @FXML
    private TableColumn<TaxData, Double> incomeColumn;
    @FXML
    private TableColumn<TaxData, Double> deductionColumn;
    @FXML
    private TableColumn<TaxData, Double> taxPercentageColumn;
    @FXML
    private TableColumn<TaxData, Double> taxableIncomeColumn;
    @FXML
    private TableColumn<TaxData, Double> totalTaxColumn;
    @FXML
    private TextField incomeTextfield;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        monthCombobox.getItems().addAll("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");

        monthColumn.setCellValueFactory(new PropertyValueFactory<TaxData, String>("month"));
        incomeColumn.setCellValueFactory(new PropertyValueFactory<TaxData, Double>("income"));
        deductionColumn.setCellValueFactory(new PropertyValueFactory<TaxData, Double>("deduction"));
        taxPercentageColumn.setCellValueFactory(new PropertyValueFactory<TaxData, Double>("taxPercentage"));
        taxableIncomeColumn.setCellValueFactory(new PropertyValueFactory<TaxData, Double>("taxableIncome"));
        totalTaxColumn.setCellValueFactory(new PropertyValueFactory<TaxData, Double>("totalTax"));

        
    }  
    
    @FXML
    private void calculateTaxableIncomeButton(MouseEvent event) {
        double income = Double.parseDouble(incomeTextfield.getText());
        double deduction = Double.parseDouble(deductionTextfield.getText());
        double taxableIncome = TaxData.calculateTaxableIncome(income, deduction);

        taxableIncomeLabel.setText(Double.toString(taxableIncome));

    }

    @FXML
    private void calculateTaxButton(MouseEvent event) {

        double taxPercentage = Double.parseDouble(taxPercentageTextfield.getText());
        double taxableIncome = Double.parseDouble(taxableIncomeLabel.getText());
        double totalTax = TaxData.calculateTax(taxableIncome, taxPercentage);

        totalTaxLabel.setText(String.valueOf(totalTax));
     
    }

    @FXML
    private void addDataButtonOnClick(MouseEvent event) {
        String month = monthCombobox.getValue();
        double income = Double.parseDouble(incomeTextfield.getText());
        double deduction = Double.parseDouble(deductionTextfield.getText());
        double taxPercentage = Double.parseDouble(taxPercentageTextfield.getText());
        double taxableIncome = TaxData.calculateTaxableIncome(income, deduction);
        double totalTax = TaxData.calculateTax(taxableIncome, taxPercentage);

        AccountsManager.addTaxData(month, income, deduction, taxPercentage, taxableIncome, totalTax);

    }

    @FXML
    private void viewDataButtonOnClick(MouseEvent event) {
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("TaxData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            TaxData F;
            try{
                while(true){
                    F = (TaxData)ois.readObject();
                    taxDataTable.getItems().add(F);
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
    
    }

    @FXML
    private void downloadTaxReportButton(MouseEvent event) {
        TaxData b = taxDataTable.getSelectionModel().getSelectedItem();
        
        PDFGenerator.generatePdf(b.toString());
    }
    

    
    
}
