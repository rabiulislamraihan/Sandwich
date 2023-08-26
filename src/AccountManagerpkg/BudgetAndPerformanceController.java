
package AccountManagerpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import static java.lang.Math.abs;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class BudgetAndPerformanceController implements Initializable {

    @FXML
    private TextField budgetTextField;
    @FXML
    private TextField projectedRevenueTextField;
    @FXML
    private TextField actualRevenueTextField;
    @FXML
    private TableView<BudgetAndPerformance> budgetDataTable;
    @FXML
    private TableColumn<BudgetAndPerformance, String> budgetMonthColumn;
    @FXML
    private TableColumn<BudgetAndPerformance, Double> budgetColumn;
    @FXML
    private TableColumn<BudgetAndPerformance, Double> projectedRevenueColumn;
    @FXML
    private TableColumn<BudgetAndPerformance, Double> projectedExpensesColumn;
    @FXML
    private ComboBox<String> selectMonthToAddDataCombobox;
    @FXML
    private ComboBox<String> selectMonthToSeePerformanceCombonox;
    @FXML
    private TextField actualExpensesTextField;
    @FXML
    private TableView<BudgetAndPerformance> performanceDataTable;
    @FXML
    private TableColumn<BudgetAndPerformance, String> performanceMonthColumn;
    @FXML
    private TableColumn<BudgetAndPerformance, Double> revenueVarianceColumn;
    @FXML
    private TableColumn<BudgetAndPerformance, Double> expensesVarianceColumn;
    @FXML
    private TextField projectedExpensesTextField;
    @FXML
    private Label revenueVarianceLabel;
    @FXML
    private Label expensesVarianceLabel;
    ArrayList <BudgetAndPerformance> list;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateMonthComboBoxes();
        budgetMonthColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance, String>("month"));
        budgetColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance, Double>("budget"));
        projectedRevenueColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance, Double>("projectedRevenue"));
        projectedExpensesColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance, Double>("projectedExpenses"));
        
        
        performanceMonthColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance, String>("month"));
        revenueVarianceColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance, Double>("revenueVariance"));
        expensesVarianceColumn.setCellValueFactory(new PropertyValueFactory<BudgetAndPerformance, Double>("expensesVariance"));
    }    
    

    public void populateMonthComboBoxes() {
        selectMonthToSeePerformanceCombonox.getItems().clear();
        selectMonthToAddDataCombobox.getItems().clear();
        
        list = AccountsManager.getEnteredMonths();
        for (int i = 0; i < list.size(); i ++) {
            if(list.get(i).getActualExpenses()==0) {
                selectMonthToSeePerformanceCombonox.getItems().add(list.get(i).getMonth());
            }
        }
        
        ArrayList<String> monthList = new ArrayList<>();
        monthList.add("January");
        monthList.add("February");
        monthList.add("March");
        monthList.add("April");
        monthList.add("May");
        monthList.add("June");
        monthList.add("July");
        monthList.add("August");
        monthList.add("September");
        monthList.add("October");
        monthList.add("November");
        monthList.add("December");
        
        for (int i = 0; i < monthList.size(); i ++) {
            boolean found = false;
            for (int j = 0; j < list.size(); j ++) {
                if(monthList.get(i).equals(list.get(j).getMonth())) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                selectMonthToAddDataCombobox.getItems().add(monthList.get(i));
            }
        }
        
    }
    


    @FXML
    private void addBudgetDataButtonOnClick(MouseEvent event) {
        String month = selectMonthToAddDataCombobox.getValue().toString();
        double budget = Double.parseDouble(budgetTextField.getText());
        double projectedRevenue = Double.parseDouble(projectedRevenueTextField.getText());
        double projectedExpenses= Double.parseDouble(projectedExpensesTextField.getText());
        


        AccountsManager.addProjectedData(
                                      month,
                                      budget,
                                      projectedRevenue,
                                      projectedExpenses
                                    );
        populateMonthComboBoxes();
        
    }

    @FXML
    private void viewBudgetDataButtonOnClick(MouseEvent event) {
        budgetDataTable.getItems().clear();
        list = AccountsManager.getEnteredMonths();
        ObservableList <BudgetAndPerformance> oList = FXCollections.observableArrayList();
        for (int i = 0; i < list.size(); i++) {
            oList.add(list.get(i));
        }
        budgetDataTable.getItems().addAll(oList);
        
//        File f = null;
//        FileInputStream fis = null;      
//        ObjectInputStream ois = null;
//        
//        try {
//            f = new File("ProjectedData.bin");
//            fis = new FileInputStream(f);
//            ois = new ObjectInputStream(fis);
//             BudgetAndPerformance F;
//            try{
//                while(true){
//                    F = (BudgetAndPerformance)ois.readObject();
//                    budgetDataTable.getItems().add(F);
//                }
//            }//end of nested try
//            catch(Exception e){
//                //
//            }//nested catch                
//        } catch (IOException ex) { } 
//        finally {
//            try {
//                if(ois != null) ois.close();
//            } catch (IOException ex) { }
//        }
    }
    

    @FXML
    private void addPerformanceDataButtonOnClick(MouseEvent event) {
        String month = selectMonthToSeePerformanceCombonox.getValue();
        
        double actualRevenue = Double.parseDouble(actualRevenueTextField.getText());
        double actualExpenses = Double.parseDouble(actualExpensesTextField.getText());
        double revenueVariance = 0;
        double expensesVariance = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getMonth().equals(month)) {
                revenueVariance = abs(actualRevenue - list.get(i).getProjectedRevenue());
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getMonth().equals(month)) {
                expensesVariance = abs(actualExpenses - list.get(i).getProjectedExpenses());
            }
        }
        AccountsManager.update(month, actualRevenue, actualExpenses,  revenueVariance, expensesVariance);
        
        
        

        
    }

    @FXML
    private void viewPerformanceDataButtonOnClick(MouseEvent event) {
        performanceDataTable.getItems().clear();
        list = AccountsManager.getEnteredMonths();
        ObservableList <BudgetAndPerformance> oList = FXCollections.observableArrayList();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getActualExpenses()!=0) {
                oList.add(list.get(i));

            }
        }
        performanceDataTable.getItems().addAll(oList);
    }

    @FXML
    private void calculateRevenueVarianceButtonOnClick(MouseEvent event) {
        String month = selectMonthToSeePerformanceCombonox.getValue();
        double actualRevenue = Double.parseDouble(actualRevenueTextField.getText());
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getMonth().equals(month)) {
                revenueVarianceLabel.setText(Double.toString(abs(actualRevenue - list.get(i).getProjectedRevenue())));
            }
        }
        
    }

    @FXML
    private void calculateExpensesVarianceButtonOnClick(MouseEvent event) {
        String month = selectMonthToSeePerformanceCombonox.getValue();
        double actualExpenses = Double.parseDouble(actualExpensesTextField.getText());
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getMonth().equals(month)) {
                expensesVarianceLabel.setText(Double.toString(abs(actualExpenses - list.get(i).getProjectedExpenses())));
            }
        }
    }
}
