/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MarketingExecutivepkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sumit
 */
public class CampaignPerformanceChartController implements Initializable {

    @FXML
    private ComboBox<String> selectPICombobox;
    @FXML
    private PieChart PieChart;
    ObservableList <CampaignReport> list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectPICombobox.getItems().addAll("Conversion Rate", "Engagement Rate", "Click Through Rate");
        
        
        // TODO
    }    

    @FXML
    private void viewChartButtonOnClick(MouseEvent event) {
        
        list = MarketingExecutive.getCampaignReportList();
        ObservableList <PieChart.Data> plist 
            = FXCollections.observableArrayList();
        for (int i = 0; i < list.size(); i ++) {
            if(selectPICombobox.getValue().equals("Conversion Rate")) {
                plist.add(new PieChart.Data(list.get(i).getCampaign().getCampaignName(), list.get(i).getConversionRate()));
            }
            if(selectPICombobox.getValue().equals("Engagement Rate")) {
                plist.add(new PieChart.Data(list.get(i).getCampaign().getCampaignName(), list.get(i).getEngagementRate()));
            }
            if(selectPICombobox.getValue().equals("Click Through Rate")) {
                plist.add(new PieChart.Data(list.get(i).getCampaign().getCampaignName(), list.get(i).getConversionRate()));
            }
        }
        PieChart.getData().clear();
        PieChart.setData(plist);
        
    }
    
}
