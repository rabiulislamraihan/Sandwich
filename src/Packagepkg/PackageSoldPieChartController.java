
package Packagepkg;

import customerpkg.Subscriptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import mainpkg.PDFGenerator;


public class PackageSoldPieChartController implements Initializable {

    @FXML
    private PieChart PieChart;
    private ObservableList <PieChart.Data> list 
            = FXCollections.observableArrayList();
    @FXML
    private Button DownloadButtonOnClick1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void DownloadButtonOnClick(MouseEvent event) {
        PDFGenerator.generatePdf(PieChart);
    }

    @FXML
    private void GenerateButtonOnClick(MouseEvent event) {
        
        Map<String, Integer> packageCounts = new HashMap<>();
        ArrayList <Subscriptions> subscriptionList = new ArrayList<>();
        for (int i = 0; i < subscriptionList.size(); i ++) {
            Subscriptions c = subscriptionList.get(i);
            packageCounts.put(c.getPackageID(), packageCounts.getOrDefault(c.getPackageID(), 0) + 1);
            
        }
        for (Map.Entry<String, Integer> entry : packageCounts.entrySet()) {
            list.add( new PieChart.Data(entry.getKey(), entry.getValue()) );
            PieChart.setData(list);
        }
    }
}
