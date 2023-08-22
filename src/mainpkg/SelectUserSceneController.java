
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class SelectUserSceneController implements Initializable {

    @FXML
    private RadioButton customerRadioButton;
    @FXML
    private RadioButton EmployeeRadioButton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg = new ToggleGroup();
        customerRadioButton.setToggleGroup(tg);
        EmployeeRadioButton.setToggleGroup(tg);
        // TODO
    }    

    @FXML
    private void NextButtonOnClick(MouseEvent event) throws IOException {
        if(customerRadioButton.isSelected()) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/customerpkg/CustomerLoginPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/employeepkg/EmployeeLoginPageScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        }
    }
    
}
