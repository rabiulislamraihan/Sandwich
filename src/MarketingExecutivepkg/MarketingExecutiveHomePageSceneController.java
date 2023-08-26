
package MarketingExecutivepkg;

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


public class MarketingExecutiveHomePageSceneController implements Initializable {

    @FXML
    private BorderPane BorderPane;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ViewPersonalInformationOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Accounts/PersonalInformationScene.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
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
    private void viewUpdateBrandVisionAndGuidelinesOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BrandVisionAndGuidelines.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }

    @FXML
    private void CreateCampaignOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DesignMarketingCampaign.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
        
    }

    @FXML
    private void campaignReportOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CampaignReport.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
            
    }

    @FXML
    private void campaignPerformanceOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CampaignPerformanceChart.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }
}
