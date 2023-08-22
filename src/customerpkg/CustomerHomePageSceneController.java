
package customerpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class CustomerHomePageSceneController implements Initializable {

    @FXML
    private BorderPane BorderPane;
    private Customer c;
    
    public void data (Customer c) {
        this.c = c;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ViewPersonalInformationOnClick(ActionEvent event) {
    }

    @FXML
    private void LogoutButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) BorderPane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/mainpkg/SelectUserScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void answerSurveysOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("AnswerSurvey.fxml"));
        BorderPane.setCenter(parent);   
        
        
    }

    @FXML
    private void BuyPackageButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BuyPackage.fxml"));
        Parent root = loader.load();
        BuyPackageController ctrl = loader.getController();
        ctrl.data(c);
        BorderPane.setCenter(root);
    }
    
}
