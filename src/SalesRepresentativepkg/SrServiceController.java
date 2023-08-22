/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SalesRepresentativepkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author anika
 */
public class SrServiceController implements Initializable {

    @FXML
    private TableView<Package> serviceTable;
    @FXML
    private TableColumn<Package, String> serviceTitle;
    @FXML
    private TableColumn<Package, Integer> serviceDuration;
    @FXML
    private TableColumn<Package, String> serviceRegion;
    @FXML
    private TableColumn<Package, String> serviceAvailable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceTitle.setCellValueFactory(new PropertyValueFactory<Package,String>("Title"));
        serviceDuration.setCellValueFactory(new PropertyValueFactory<Package,Integer>("Duration"));
        serviceRegion.setCellValueFactory(new PropertyValueFactory<Package,String>("Region"));
        serviceAvailable.setCellValueFactory(new PropertyValueFactory<Package,String>("Available"));
        // TODO
        loadTableViewData();
    }    
    private void loadTableViewData() {
        ObjectInputStream ois = null;
        ObservableList<Package> data = FXCollections.observableArrayList();
        data.clear();
        serviceTable.setItems(data);
        try {
             Package c;
             ois = new ObjectInputStream(new FileInputStream("p.bin"));
             
            while(true){
                c = (Package) ois.readObject();
                serviceTable.getItems().add(c);
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
    }
    @FXML
    private void serviceLoadTable(MouseEvent event) {
        
    }
    
}
