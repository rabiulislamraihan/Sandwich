/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AccountManagerpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sumit
 */
public class VisualizeBudgetAndPerformanceController implements Initializable {

    @FXML
    private NumberAxis numberaxis;
    @FXML
    private CategoryAxis xaxis;
    @FXML
    private BarChart<String, Number> visualizeBarChart;
    @FXML
    private ComboBox<String> selectTypeCombobox;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectTypeCombobox.getItems().addAll(
                "Budget",
                "Projected Expenses",
                "Projected Revenue",
                "Actual Expenses",
                "Actual Revenue",
                "Revenue Variance",
                "Expenses Variance");
           
    }    

    @FXML
    private void showChartButtonOnClick(MouseEvent event) {
        String item = selectTypeCombobox.getValue();
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();

        ObjectInputStream ois = null;
        boolean result = false;
        try {
             BudgetAndPerformance c;
             ois = new ObjectInputStream(new FileInputStream("BudgetAndPerformance.bin"));
             
            while(true){
                c = (BudgetAndPerformance) ois.readObject();
                Double value = null;
                if(item.equals("Budget")){
                    value = c.getBudget();
                }
                if(item.equals("Projected Expenses")){
                    value = c.getProjectedExpenses();
                }
                if(item.equals("Projected Revenue")){
                    value = c.getProjectedRevenue();
                }
                if(item.equals(" Actual Expenses")){
                    value = c.getActualExpenses();
                }
                if(item.equals("Actual Revenue")){
                    value = c.getActualRevenue();
                }
                if(item.equals("Revenue Variance")){
                    value = c.getRevenueVariance();
                }
                if(item.equals("Expenses Variance")){
                    value = c.getExpensesVariance();
                }
                series.getData().add(new XYChart.Data<String,Number>(c.getMonth(),value));
            
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        visualizeBarChart.getData().clear();
        visualizeBarChart.getData().add(series);
        
    }
    

    
 
}
