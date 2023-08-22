


package Analystpkg;

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

import javafx.fxml.FXML;

import javafx.fxml.Initializable;


public class AnalystHomePageSceneController implements Initializable {


    
    private Analyst c;
    @FXML
    private BorderPane BorderPane;
    
    public void data(Analyst c) {
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
    private void AnalyseBillsOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("BillAnalysis.fxml"));
        BorderPane.setCenter(parent);
    }

    @FXML
    private void hardwareAnalysisOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("HardwareAnalysis.fxml"));
        BorderPane.setCenter(parent);
    }

    @FXML
    private void CreateSurveyOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("CreateSurvey.fxml"));
        BorderPane.setCenter(parent);
    }

    @FXML
    private void viewSurveyResultsOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SurveyResults.fxml"));
        BorderPane.setCenter(parent);
    }
    
}
