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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class ViewHardwareStatsController implements Initializable {

    @FXML
    private PieChart piechart;
    private ObservableList <PieChart.Data> list = FXCollections.observableArrayList();
    @FXML
    private Label viewDetailsLabel;
    @FXML
    private TextArea stockPriceTextarea;
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
                stockPriceTextarea.appendText("Total stock price of "+h.getName() +" is "+h.HardwareStockPrice(h.getUnitsRemaining(),h.getUnitCost()) + "\n");
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
        
            for(PieChart.Data data: piechart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                    new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    viewDetailsLabel.setText("Units Remaining "+String.valueOf(data.getPieValue()));
                }
            }
            );
            
        }
        
        
        
        
    }
    
}
