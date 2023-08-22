/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Analystpkg;
import Technicianpkg.Hardware;
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
import javafx.scene.input.MouseEvent;




/**
 * FXML Controller class
 *
 * @author Hp
 */
public class HardwareAnalysisController implements Initializable {

    @FXML
    
    private PieChart piechart;
    private ObservableList <PieChart.Data> list = FXCollections.observableArrayList();
    @FXML
    private Label statusLabel;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadPiechartOnClick(ActionEvent event) {
        
         ObjectInputStream ois = null;

        try{
            Hardware h;
            ois = new ObjectInputStream(new FileInputStream("Hardware.bin"));
            
            while(true){
                h = (Hardware) ois.readObject();
                list.add(new PieChart.Data(h.getName(), h.getUnitCost()));
                
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
                    statusLabel.setText("Price is "+String.valueOf(data.getPieValue()));
                }
            }
            );
            
        }
        
            
        }
    
        
    
}
