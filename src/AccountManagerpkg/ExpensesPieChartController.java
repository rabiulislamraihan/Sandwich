/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AccountManagerpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
public class ExpensesPieChartController implements Initializable {

    @FXML
    private PieChart expensesPieChart;
    @FXML
    private ComboBox<String> monthCombox;
    private ObservableList <PieChart.Data> list = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        monthCombox.getItems().addAll("January", 
                "February", 
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "Octobetr",
                "November",
                "December");
        // TODO
    }    

    @FXML
    private void showChartButtonOnClick(MouseEvent event) {
        ObjectInputStream ois = null;

        try{
            
            IncomeStatement m;
            ois = new ObjectInputStream(new FileInputStream("IncomeData.bin"));
            
            while(true){
                m = (IncomeStatement) ois.readObject();
                if(m.getMonth().equals(monthCombox.getValue())){
                    list.add(new PieChart.Data("salaryAndWages" , m.getSalaryAndWages()));
                    list.add(new PieChart.Data("rentAndUtilities" , m.getRentAndUtilities()));
                    list.add(new PieChart.Data("contentAcquisition" , m.getContentAcquisition()));
                    list.add(new PieChart.Data("marketingCost" , m.getMarketingCost()));
                   
                    expensesPieChart.setData(list);
                    return;
                    
                }
                

            }
            
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            try {
                if(ois!=null){
                    ois.close();
                }
            }
            catch (IOException ex1){ }
        }
        
    }
    
}
