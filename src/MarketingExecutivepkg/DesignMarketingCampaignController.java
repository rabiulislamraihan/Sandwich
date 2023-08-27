
package MarketingExecutivepkg;

import AccountManagerpkg.BudgetAndPerformance;
import AccountManagerpkg.IncomeStatement;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mainpkg.PDFGenerator;


public class DesignMarketingCampaignController implements Initializable {

    @FXML
    private DatePicker endDatePicker;
    @FXML
    private TextField campaignNameTextfield;
    @FXML
    private ComboBox<String> targetAudienceCombobox;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private ComboBox<String> marketingMediaCombobox;
    @FXML
    private TableView<DesignCampaign> campaignTable;
    @FXML
    private TableColumn<DesignCampaign, String> nameColumn;
    @FXML
    private TableColumn<DesignCampaign, LocalDate> startDateColumn;
    @FXML
    private TableColumn<DesignCampaign, LocalDate> endDateColumn;
    @FXML
    private TableColumn<DesignCampaign, LocalDate> durationColumn;
    @FXML
    private TableColumn<DesignCampaign, String> mediaColumn;
    @FXML
    private TableColumn<DesignCampaign, String> targetAudienceColumn;
    @FXML
    private TextField campaignContentTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<DesignCampaign, String>("campaignName"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<DesignCampaign, LocalDate>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<DesignCampaign, LocalDate>("endDate"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<DesignCampaign, LocalDate>("duration"));
        mediaColumn.setCellValueFactory(new PropertyValueFactory<DesignCampaign, String>("marketingMedia"));
        targetAudienceColumn.setCellValueFactory(new PropertyValueFactory<DesignCampaign, String>("targetAudience"));
        
        targetAudienceCombobox.getItems().addAll(
            "General Audience",
            "Sports Enthusiasts",
            "Movie Lovers",
            "News Subscribers",
            "Kids' Content Viewers",
            "Educational and Learning"
            
        );

       
        marketingMediaCombobox.getItems().addAll(
            "TV Advertisements",
            "Social Media",
            "Email Campaigns",
            "SMS Marketing"
           
        );
    }

    @FXML
    private void viewCampaignDetailsButtonOnClick(MouseEvent event) {
        ObservableList <DesignCampaign> list = MarketingExecutive.getCampaignList();
        campaignTable.getItems().clear();
        campaignTable.getItems().addAll(list);
    }

    @FXML
    private void addCampaignButtonOnClick(MouseEvent event) {
        String campaignName = campaignNameTextfield.getText();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        String targetAudience = targetAudienceCombobox.getValue();
        String marketingMedia = marketingMediaCombobox.getValue();
        String campaignContent = campaignContentTextField.getText();
        
        DesignCampaign dp = new DesignCampaign(campaignName, startDate, endDate, campaignContent, targetAudience, marketingMedia);
        MarketingExecutive.addCampaign(dp);
    }

    @FXML
    private void downloadCampaignDetailsButtonOnClick(MouseEvent event) {
        DesignCampaign b = campaignTable.getSelectionModel().getSelectedItem();
        
        PDFGenerator.generatePdf(b.toString());
    
    }

    @FXML
    private void ViewContentDetailsOnClick(MouseEvent event) throws IOException {
        
        Stage stage = new Stage();
        DesignCampaign dc = campaignTable.selectionModelProperty().getValue().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ContentDetailsScene.fxml"));
        Parent root = loader.load();
        ContentDetailsSceneController ctrl = loader.getController();
        ctrl.data(dc);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
