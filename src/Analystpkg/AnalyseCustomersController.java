/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Analystpkg;

import customerpkg.Customer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class AnalyseCustomersController implements Initializable {

    @FXML
    private BarChart<String, Number> barcharrt;
    @FXML
    private NumberAxis NoOfCustomers;
    @FXML
    private CategoryAxis AgeRange;

            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        int A = 0;
        int M = 0;
        int V = 0;
        int Z = 0;
        
//        prints in console
         ObjectInputStream ois=null;
         try {
            Customer c;
            ois = new ObjectInputStream(new FileInputStream("Customer.bin"));
            
            while(true){
            c = (Customer)ois.readObject();
            Period age = Period.between(c.getDateOfBirth(), LocalDate.now());
            if(age.getYears()<5){
                A++;
            }
            else if(age.getYears()<10){
                M++;
            }
            else if(age.getYears()<15){
                V++;
            }
            else{
                Z++;
            }
            System.out.println(c.toString());
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
        series.getData().add(new XYChart.Data<String,Number>("0-5 years" , A));
        series.getData().add(new XYChart.Data<String,Number>("5-10 years" , M));
        series.getData().add(new XYChart.Data<String,Number>("10-15 years" , V));
        series.getData().add(new XYChart.Data<String,Number>("15-20 years" , Z));
        series.setName("User Age Demographic");
        barcharrt.getData().add(series);
        AgeRange.setLabel("Age Range of Customers");
        NoOfCustomers.setLabel("No. of Customers");
       
        
    }
        
       
        
    }    
    

