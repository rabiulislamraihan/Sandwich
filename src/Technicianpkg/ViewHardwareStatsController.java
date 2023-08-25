/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Technicianpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class ViewHardwareStatsController implements Initializable {

    @FXML
    private PieChart piechart;
    private ObservableList <PieChart.Data> list = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewHardwareStatsOnClick(ActionEvent event) {
        
         ObjectInputStream ois = null;

        try{
            Hardware h;
            ois = new ObjectInputStream(new FileInputStream("Hardware.bin"));
            
            while(true){
                h = (Hardware) ois.readObject();
                list.add(new PieChart.Data(h.name, h.unitsRemaining));

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
        
        
        
        piechart.setData(list);
    }
    
}
