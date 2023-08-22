// Hi zaara
package AccountManagerpkg;

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


public class AccountManagerHomePageSceneController implements Initializable {

    @FXML
    private BorderPane BorderPane;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ViewPersonalInformationOnClick(ActionEvent event) throws IOException {

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
    private void createFinancialDataMenuitem(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Financial Reporting.fxml"));
        BorderPane.setCenter(parent);
    }

    @FXML
    private void generateFinancialReportMenuitem(ActionEvent event) {
    }

    @FXML
    private void createbillmenuitem(ActionEvent event) {
    }

    @FXML
    private void SalaryDisbursementOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/employeepkg/SalaryDisbursementScene.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }

    @FXML
    private void SeeEmployeeSalaryDetails(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/employeepkg/SeeEmployeeSalaryDetails.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }
    
}
