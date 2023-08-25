
package customerpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.Account;


public class CustomerLoginPageController implements Initializable {

    @FXML
    private TextField customerIDTextField;
    @FXML
    private TextField PasswordTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void LoginButtonOnClick(MouseEvent event) throws IOException {
        int id = Integer.parseInt(customerIDTextField.getText());
        String password = PasswordTextField.getText();
        if(!Account.CheckCustomerAccountExistence(id)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Account Doesn't Exists !");
            a.showAndWait();
            return;
        }
        if(!Account.CustomerpasswordMatch(id, password)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Password didn't Match !");
            a.showAndWait();
            return;
        }
        Customer c = Account.getCustomerInstance(id);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/customerpkg/CustomerHomePageScene.fxml"));
        Parent root = loader.load();
        CustomerHomePageSceneController ctrl = loader.getController();
        ctrl.data(c);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void CreateNewAccountOnClick(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Administratorpkg/CreateNewAccountCustomerScene.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void BackButtonClick(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/mainpkg/SelectUserScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
