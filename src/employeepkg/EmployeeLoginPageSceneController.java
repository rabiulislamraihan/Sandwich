
package employeepkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class EmployeeLoginPageSceneController implements Initializable {

    @FXML
    private ComboBox<String> designationComboBox;
    @FXML
    private TextField employeeIDTextField;
    @FXML
    private TextField passwordTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        designationComboBox.getItems().addAll(
                "Administrator",
                "Account Manager",
                "Analyst",
                "Content Manager",
                "Marketing Executive",
                "Sales Representative",
                "Technician");
        // TODO
    }    

    @FXML
    private void LoginButtonOnClick(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = null;
        if(designationComboBox.getValue().equals("Administrator")) {
            loader = new FXMLLoader(getClass().getResource("/Administratorpkg/AdministratorHomePageScene.fxml"));
            
        }
        if(designationComboBox.getValue().equals("Account Manager")) {
            loader = new FXMLLoader(getClass().getResource("/AccountManagerpkg/AccountManagerHomePageScene.fxml"));
            
        }
        if(designationComboBox.getValue().equals("Analyst")) {
            loader = new FXMLLoader(getClass().getResource("/Analystpkg/AnalystHomePageScene.fxml"));
        }
        if(designationComboBox.getValue().equals("Content Manager")) {
            loader = new FXMLLoader(getClass().getResource("/ContentManagerpkg/ContentManagerHomePageScene.fxml"));
            
        }
        if(designationComboBox.getValue().equals("Marketing Executive")) {
            loader = new FXMLLoader(getClass().getResource("/MarketingExecutivepkg/MarketingExecutiveHomePageScene.fxml"));
            
        }
        if(designationComboBox.getValue().equals("Sales Representative")) {
            loader = new FXMLLoader(getClass().getResource("/SalesRepresentativepkg/SalesRepresentativeHomePageScene.fxml"));
            
        }
        if(designationComboBox.getValue().equals("Technician")) {
            loader = new FXMLLoader(getClass().getResource("/Technicianpkg/TechnicianHomePageScene.fxml"));
            
        }
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
}
