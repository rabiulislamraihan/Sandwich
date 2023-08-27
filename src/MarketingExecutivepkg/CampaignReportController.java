/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MarketingExecutivepkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sumit
 */
public class CampaignReportController implements Initializable {

    @FXML
    private ComboBox<String> selectCampaignCombobox;
    @FXML
    private TextField totalImpressionsTextfield;
    @FXML
    private TextField totalEngagementTexfield;
    @FXML
    private TextField totalClicksTextfield;
    @FXML
    private TextField totalActionsTextfield;
    @FXML
    private Label engagementRateLabel;
    @FXML
    private Label CTRLabel;
    @FXML
    private Label conversionRateLabel;
    @FXML
    private TableView<CampaignReport> reportTable;
    @FXML
    private TableColumn<CampaignReport, String> campaignNameColumn;
    @FXML
    private TableColumn<CampaignReport, Integer> impressionsColumn;
    @FXML
    private TableColumn<CampaignReport, Integer> engagementColumn;
    @FXML
    private TableColumn<CampaignReport, Integer> clicksColumn;
    @FXML
    private TableColumn<CampaignReport, Integer> actionsColumn;
    
    ObservableList <DesignCampaign> list;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list = MarketingExecutive.getCampaignList();
        for (int i = 0; i < list.size(); i ++) {
            selectCampaignCombobox.getItems().add(list.get(i).getCampaignName());
        }
        
        campaignNameColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getCampaign().getCampaignName());});
        
        impressionsColumn.setCellValueFactory(new PropertyValueFactory<CampaignReport, Integer>("totalImpressions"));
        engagementColumn.setCellValueFactory(new PropertyValueFactory<CampaignReport, Integer>("totalEngagements"));
        clicksColumn.setCellValueFactory(new PropertyValueFactory<CampaignReport, Integer>("totalClicks"));
        actionsColumn.setCellValueFactory(new PropertyValueFactory<CampaignReport, Integer>("totalActions"));
    }    

    @FXML
    private void showCTRButton(MouseEvent event) {
        
        int totalClicks = Integer.parseInt(totalClicksTextfield.getText());
        int totalImpressions = Integer.parseInt(totalImpressionsTextfield.getText());

        CTRLabel.setText(Double.toString(totalClicks * 100.0 / totalImpressions));
    }

    @FXML
    private void showConversionRateButton(MouseEvent event) {
        int totalActions = Integer.parseInt(totalActionsTextfield.getText());
        int totalClicks = Integer.parseInt(totalClicksTextfield.getText());

        conversionRateLabel.setText(Double.toString(totalActions * 100.0 / totalClicks));
    }

    @FXML
    private void showEngagementRateButton(MouseEvent event) {
        int totalEngagements = Integer.parseInt(totalEngagementTexfield.getText());
        int totalImpressions = Integer.parseInt(totalImpressionsTextfield.getText());
        engagementRateLabel.setText(Double.toString(totalEngagements *100.0 / totalImpressions));
    
    }

    @FXML
    private void addButton(MouseEvent event) {
        int totalClicks = Integer.parseInt(totalClicksTextfield.getText());
        int totalImpressions = Integer.parseInt(totalImpressionsTextfield.getText());
        int totalActions = Integer.parseInt(totalActionsTextfield.getText());
        int totalEngagements = Integer.parseInt(totalEngagementTexfield.getText());
        double engagementRate = Double.parseDouble(engagementRateLabel.getText());
        double clickThroughRate = Double.parseDouble(CTRLabel.getText());
        double conversionRate = Double.parseDouble(conversionRateLabel.getText());
        DesignCampaign dc = null;
        for (int i = 0; i < list.size(); i ++) {
            if(list.get(i).getCampaignName().equals(selectCampaignCombobox.getValue())) {
                dc = list.get(i);
            }
        }
        CampaignReport cr = new CampaignReport(dc, totalImpressions, totalEngagements, totalClicks, totalActions, engagementRate, clickThroughRate,  conversionRate);
        MarketingExecutive.addCampaignReport(cr);
    }

    @FXML
    private void viewButton(MouseEvent event) {
        reportTable.getItems().clear();
        reportTable.getItems().addAll(MarketingExecutive.getCampaignReportList());

    }
}
