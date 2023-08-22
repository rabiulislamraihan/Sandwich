package Technicianpkg;

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

public class TechnicianHomePageSceneController implements Initializable {

    
    private Technician c;
    @FXML
    private BorderPane BorderPane;
    
    public void data(Technician c) {
        this.c = c;
    }
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
    private void newSetupOnClick(ActionEvent event) throws IOException {
        
    }

    @FXML
    private void maintenanceOnClick(ActionEvent event) throws IOException {
        
    }

    @FXML
    private void CreateReportOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ReportHandling.fxml"));
        BorderPane.setCenter(parent);
    }

    @FXML
    private void CreateBillOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("GenerateBill.fxml"));
        BorderPane.setCenter(parent);
    }

    @FXML
    private void OpenInventoryOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("HardwareInventory.fxml"));
        BorderPane.setCenter(parent);
    }

    @FXML
    private void analyseInventoryOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ViewHardwareStats.fxml"));
        BorderPane.setCenter(parent);
    }

    @FXML
    private void AnswerQueriesOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("HardwareInventory.fxml"));
        BorderPane.setCenter(parent);
    }

    @FXML
    private void AddClientHistoryOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ClientHistory.fxml"));
        BorderPane.setCenter(parent);
    }
    
}
