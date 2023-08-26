/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MarketingExecutivepkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class ContentDetailsSceneController implements Initializable {

    @FXML
    private TextArea showDetailsTextarea;
    private DesignCampaign dp;
    public void data(DesignCampaign dp) {
        this.dp = dp;
        showDetailsTextarea.setText(dp.getContent());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
