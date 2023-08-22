/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Analystpkg;
import Technicianpkg.Bill;
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
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class BillAnalysisController implements Initializable {

    @FXML
    private BarChart<String, Number> barchart;
    @FXML
    private NumberAxis TotalExpenditure;
    @FXML
    private CategoryAxis Users;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
         ObjectInputStream ois = null;

        try{
            Bill b;
            ois = new ObjectInputStream(new FileInputStream("Bill.bin"));
            
            while(true){
                b = (Bill) ois.readObject();
                series.getData().add(new XYChart.Data<String, Number>(b.getClient() ,b.getTotal()));
                
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
        barchart.getData().add(series);
        
    }
        
        
    }    
    

