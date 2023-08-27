/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Analystpkg;


import Administratorpkg.Administrator;
import customerpkg.Subscriptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class PackageDemandController implements Initializable {

    @FXML
    private ComboBox<String> selectPackageCombobox;
    @FXML
    private TextArea detailsTextarea;
    private ArrayList<String>listOfPackages = new ArrayList<>();
    private ArrayList<Subscriptions>listOfAllPackages = new ArrayList<>();
        private ArrayList<Subscriptions>listOfUniquePackages = new ArrayList<>();
    private ObservableList <PieChart.Data> list 
            = FXCollections.observableArrayList();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ObjectInputStream ois = null;

        try{
            Subscriptions s;
            ois = new ObjectInputStream(new FileInputStream("Subscriptions.bin"));
            
            while(true){
                s = (Subscriptions) ois.readObject();
               listOfAllPackages.add(s);
                if(!listOfPackages.contains(s.getPackageID())){
                    listOfPackages.add(s.getPackageID());
                    listOfUniquePackages.add(s);
                selectPackageCombobox.getItems().addAll(s.getPackageID());
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

    @FXML
    private void viewDetailsOnClick(ActionEvent event) {
        
        String pkg = selectPackageCombobox.getValue();
        String name = "";
        int price = 0;
        int customers=0;
        
        
        ObjectInputStream ois = null;

        try{
            Subscriptions s;
            ois = new ObjectInputStream(new FileInputStream("Subscriptions.bin"));
            
            while(true){
                s = (Subscriptions) ois.readObject();
                if(s.getPackageID().equals(pkg)){
                    name = s.getPackageID();
                    price = s.getPrice();
                    
                    customers++;
     
                    detailsTextarea.setText("Name of Package: "+name +"\n"+ "Price of Package: "+ 
                            price + "\n" + "No. of customers: "+ customers);
                    
                
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