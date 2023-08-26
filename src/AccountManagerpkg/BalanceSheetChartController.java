/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AccountManagerpkg;

import java.io.EOFException;
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
public class BalanceSheetChartController implements Initializable {

    @FXML
    private BarChart<String, Number> balanceSheetChart;
    @FXML
    private ComboBox<String> selectChartDataTypeCombobox;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectChartDataTypeCombobox.getItems().addAll(
                "Total Assets",
                "Total Liabilities",
                "Owner's Equity");
        // TODO
    }    

    @FXML
    private void showBalanceSheetChart(MouseEvent event) {
        String item = selectChartDataTypeCombobox.getValue();
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();

        ObjectInputStream ois = null;
        boolean result = false;
        try {
             BalanceSheetData c;
             ois = new ObjectInputStream(new FileInputStream("BalanceSheetData.bin"));
             
            while(true){
                c = (BalanceSheetData) ois.readObject();
                Double value = null;
                if(item.equals("Total Assets")){
                    value = c.getTotalassets();
                }
                if(item.equals("Total Liabilities")){
                    value = c.getTotalliabilities();
                }
                if(item.equals("Owner's Equity")){
                    value = c.getOwnersequity();
                }
                series.getData().add(new XYChart.Data<String, Number>(c.getMonth(), value));
                
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
        balanceSheetChart.getData().clear();
        balanceSheetChart.getData().add(series);
    }

    @FXML
    private void backButtonOnClick(MouseEvent event) {
    }
    
        


}