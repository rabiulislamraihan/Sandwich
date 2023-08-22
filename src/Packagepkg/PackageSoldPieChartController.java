/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Packagepkg;

import customerpkg.Subscriptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import mainpkg.PDFGenerator;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class PackageSoldPieChartController implements Initializable {

    @FXML
    private PieChart PieChart;
    private ObservableList <PieChart.Data> list 
            = FXCollections.observableArrayList();
    @FXML
    private Button DownloadButtonOnClick1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void DownloadButtonOnClick(MouseEvent event) {
        PDFGenerator.generatePdf(PieChart);
    }

    @FXML
    private void GenerateButtonOnClick(MouseEvent event) {
        ObjectInputStream ois = null;
        Map<String, Integer> packageCounts = new HashMap<>();
        try {
             Subscriptions c;
             ois = new ObjectInputStream(new FileInputStream("Subscriptions.bin"));
             
            while(true){
                c = (Subscriptions) ois.readObject();
                packageCounts.put(c.getPackageID(), packageCounts.getOrDefault(c.getPackageID(), 0) + 1);
                
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
        
        for (Map.Entry<String, Integer> entry : packageCounts.entrySet()) {
            list.add( new PieChart.Data(entry.getKey(), entry.getValue()) );
            PieChart.setData(list);
        }
    }
    
}
