/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AccountManagerpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sumit
 */
public class VisualizeVarianceController implements Initializable {

    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private NumberAxis numberaxis;
    @FXML
    private CategoryAxis xaxis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttononclick(MouseEvent event) {
    }
    
}
