
package AccountManagerpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;


public class VisualizeVarianceController implements Initializable {

    @FXML
    private NumberAxis numberaxis;
    @FXML
    private CategoryAxis xaxis;
    @FXML
    private BarChart<String, Number> visualizeBarChart;
    @FXML
    private ComboBox<String> selectTypeCombobox;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectTypeCombobox.getItems().addAll(
                "Revenue Variance",
                "Expenses Variance");
           
    }    

    @FXML
    private void showChartButtonOnClick(MouseEvent event) {
        String item = selectTypeCombobox.getValue();
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();

        ObjectInputStream ois = null;
        boolean result = false;
        try {
              BudgetAndPerformance c;
             ois = new ObjectInputStream(new FileInputStream("ProjectedData.bin"));
             
            while(true){
                c = (BudgetAndPerformance) ois.readObject();
                
                if(item.equals("Revenue Variance")){
                    series.getData().add(new XYChart.Data<String, Number>(c.getMonth(), c.getRevenueVariance()));
                }
                else {
                    series.getData().add(new XYChart.Data<String, Number>(c.getMonth(), c.getExpensesVariance()));
                }
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        visualizeBarChart.getData().clear();
        visualizeBarChart.getData().add(series);
    }

}
