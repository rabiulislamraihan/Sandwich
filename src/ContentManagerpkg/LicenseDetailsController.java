/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ContentManagerpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author anika
 */
public class LicenseDetailsController implements Initializable {

    @FXML
    private TextArea licenseDesciption;
    @FXML
    private TextField licenseTitle;
    @FXML
    private TextField cName;
    @FXML
    private TextField activeStatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void data(License p) {
        licenseTitle.setText(p.getLicenseTitle());
        cName.setText(p.getContractorName());
        activeStatus.setText(p.getActiveStatus());
        licenseDesciption.setText(p.getDescription());
    }
    
}
