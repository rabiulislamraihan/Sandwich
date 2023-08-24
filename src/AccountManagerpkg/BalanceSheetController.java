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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sumit
 */
public class BalanceSheetController implements Initializable {

    @FXML
    private TableView<BalanceSheetData> BalanceSheetTable;
    @FXML
    private TableColumn<BalanceSheetData, String> balanceSheetMonthColumn;
    @FXML
    private TableColumn<BalanceSheetData, Double> balanceSheetAssetsColumn;
    @FXML
    private TableColumn<BalanceSheetData, Double> balanceSheetLiabilityColumn;
    @FXML
    private TableColumn<BalanceSheetData, Double> balanceSheetOwnersEquityColumn;
    @FXML
    private TextField cashTextfield;
    @FXML
    private TextField accountsReceivableTextfield;
    @FXML
    private TextField investmentTextfield;
    @FXML
    private TextField totalAssetsTextfield;
    @FXML
    private TextField accountPayableTextfield;
    @FXML
    private TextField loanTextfield;
    @FXML
    private TextField ownersEquityTextfield;
    @FXML
    private TextField totalLiabilityTextfield;
    @FXML
    private ComboBox<String> selectMonthForBalanceSheetCombobox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList <String> monthList = new ArrayList<>();
        ArrayList <String> AllMonths = new ArrayList<>();
        AllMonths.add("January");
        AllMonths.add("February");
        AllMonths.add("March");
        AllMonths.add("April");
        AllMonths.add("May");
        AllMonths.add("June");
        AllMonths.add("July");
        AllMonths.add("August");
        AllMonths.add("September");
        AllMonths.add("Octobetr");
        AllMonths.add("November");
        AllMonths.add("December");
        
        ObjectInputStream ois = null;

        try{
            
            FinancialMatrices m;
            ois = new ObjectInputStream(new FileInputStream("FinancialMatrices.bin"));
            
            while(true){
                m = (FinancialMatrices) ois.readObject();
                monthList.add(m.getMonth());
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
        for (int i = 0; i < AllMonths.size(); i ++) {
            boolean found = false;
            for (int j = 0; j < monthList.size(); j ++) {
                if(AllMonths.get(i).equals(monthList.get(j))) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                selectMonthForBalanceSheetCombobox.getItems().add(AllMonths.get(i));
            }
        }

        
        
        balanceSheetMonthColumn.setCellValueFactory(new PropertyValueFactory<BalanceSheetData, String> ("month"));
        balanceSheetAssetsColumn.setCellValueFactory(new PropertyValueFactory<BalanceSheetData, Double> ("totalassets"));
        balanceSheetLiabilityColumn.setCellValueFactory(new PropertyValueFactory<BalanceSheetData, Double> ("totalliabilities"));
        balanceSheetOwnersEquityColumn.setCellValueFactory(new PropertyValueFactory<BalanceSheetData, Double> ("ownersequity"));
        
        
    }    
    
    @FXML
    private void calculateTotalAssetsButtonOnMouseClick(MouseEvent event) {
        double CASH = Double.parseDouble(cashTextfield.getText());
        double ACCOUNTSRECEIVABLE = Double.parseDouble(accountsReceivableTextfield.getText());
        double INVESTMENT = Double.parseDouble(investmentTextfield.getText());

        double TOTALASSETS = BalanceSheetData.calculateTotalAssets(CASH,ACCOUNTSRECEIVABLE,INVESTMENT);

        totalAssetsTextfield.setText(String.valueOf(TOTALASSETS));
          
    }

    @FXML
    private void calculateTotalLiabilitiesButtonOnMouseClick(MouseEvent event) {
        double ACCOUNTSPAYABLE = Double.parseDouble(accountPayableTextfield.getText());
        double LOAN = Double.parseDouble(loanTextfield.getText());

        double TOTALLIABILITIES = BalanceSheetData.calculateTotalLiabilities(ACCOUNTSPAYABLE, LOAN);

        totalLiabilityTextfield.setText(String.valueOf(TOTALLIABILITIES));
        
    }

    @FXML
    private void calculateOwnersEquityButtonOnMouseClick(MouseEvent event) {
        double TOTALASSETS = Double.parseDouble(totalAssetsTextfield.getText());
        double TOTALLIABILITIES = Double.parseDouble(totalLiabilityTextfield.getText());

        double OWNERSEQUITY = BalanceSheetData.calculateOwnersEquity(TOTALASSETS, TOTALLIABILITIES);

        ownersEquityTextfield.setText(String.valueOf(OWNERSEQUITY));
    }

    @FXML
    private void viewBalanceSheetChartButtonOnClick(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("BalanceSheetChart.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        
    }
      
              

    @FXML
    private void addBalanceSheetDataButtonOnClick(MouseEvent event) {
        String MONTH = selectMonthForBalanceSheetCombobox.getValue();
        double CASH = Double.parseDouble(cashTextfield.getText());
        double ACCOUNTSRECEIVABLE = Double.parseDouble(accountsReceivableTextfield.getText());
        double INVESTMENT = Double.parseDouble(investmentTextfield.getText());
        double ACCOUNTSPAYABLE = Double.parseDouble(accountPayableTextfield.getText());
        double LOAN = Double.parseDouble(loanTextfield.getText());

        double TOTALASSETS = BalanceSheetData.calculateTotalAssets(CASH, ACCOUNTSRECEIVABLE, INVESTMENT);
        double TOTALLIABILITIES = BalanceSheetData.calculateTotalLiabilities(ACCOUNTSPAYABLE, LOAN);
        double OWNERSEQUITY = BalanceSheetData.calculateOwnersEquity(TOTALASSETS, TOTALLIABILITIES);
    
        AccountsManager.CreateBalanceSheetData(MONTH, CASH, ACCOUNTSRECEIVABLE, INVESTMENT, TOTALASSETS, ACCOUNTSPAYABLE, LOAN, TOTALLIABILITIES, OWNERSEQUITY);
    }
 
    @FXML
    private void viewBalanceSheetDataButtonOnClick(MouseEvent event) {
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("BalanceSheetData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            BalanceSheetData F;
            try{
                while(true){
                    F = (BalanceSheetData)ois.readObject();
                    BalanceSheetTable.getItems().add(F);
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
}