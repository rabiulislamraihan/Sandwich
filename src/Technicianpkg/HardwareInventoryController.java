/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Technicianpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class HardwareInventoryController implements Initializable {

    @FXML
    private TextField nameOfEquipmentTextfield;
    @FXML
    private TableView<Hardware> InventoryTable;
    @FXML
    private TableColumn<Hardware, String> nameCol;
    @FXML
    private TableColumn<Hardware, Integer> unitCostCol;
    @FXML
    private TableColumn<Hardware, Integer> unitsRemainingCol;
    @FXML
    private TextField costPerUnitTextfield;
    @FXML
    private TextField unitsLeftTextfield;
    @FXML
    private ComboBox<String> equipmentCombobox;
    @FXML
    private ComboBox<String> updateCombobox;
    @FXML
    private TextField newDataTextfield;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        updateCombobox.getItems().addAll( "Unit Price", "Units Left");
        
        nameCol.setCellValueFactory(new PropertyValueFactory<Hardware,String>("name"));
        unitCostCol.setCellValueFactory(new PropertyValueFactory<Hardware,Integer>("unitCost"));
        unitsRemainingCol.setCellValueFactory(new PropertyValueFactory<Hardware,Integer>("unitsRemaining"));
        
        
        
        ObjectInputStream ois = null;

        try{
            Hardware h;
            ois = new ObjectInputStream(new FileInputStream("Hardware.bin"));
            
            while(true){
                h = (Hardware) ois.readObject();
                InventoryTable.getItems().add(h);
                equipmentCombobox.getItems().addAll(h.name);

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
    private void AddItemToInventoryOnClick(ActionEvent event) {
        String name = nameOfEquipmentTextfield.getText();
        int cost = Integer.parseInt(costPerUnitTextfield.getText());
        int unit = Integer.parseInt(unitsLeftTextfield.getText());
        Hardware h = new Hardware(name, cost, unit);
        InventoryTable.getItems().add(h);
        Technician.AddHardware(name, cost, unit);
        equipmentCombobox.getItems().addAll(name);
        

    }

    @FXML
    private void updateInventoryOnClick(ActionEvent event) {
        
        String updateItem =  equipmentCombobox.getValue();
        String updateCatagory = updateCombobox.getValue();
        int newData = Integer.parseInt(newDataTextfield.getText());
        if(newData<0){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Value cannot be less than 0!" );
            a.showAndWait();
            return;
        }
     
         InventoryTable.getItems().clear();


        ArrayList <Hardware> hardwareList = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
             Hardware h;
             ois = new ObjectInputStream(new FileInputStream("Hardware.bin"));
             
            while(true){
                h = (Hardware) ois.readObject();
                if(h.getName().equals(updateItem)){
                    if(updateCatagory.equals("Unit Price")){
                        h.setUnitCost(newData);
                    }
                    else{
                        if(newData==0){
                            continue;
                        }
                        h.setUnitsRemaining(newData);
                        
                    }
                }
                hardwareList.add(h);
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
        
        for (int i = 0; i < hardwareList.size(); i ++) {
            File f = null;
            FileOutputStream fos = null;      
            ObjectOutputStream oos = null;

            try {
                f = new File("Hardware.bin");
                if(i!=0){
                    fos = new FileOutputStream(f,true);
                    oos = new mainpkg.AppendableObjectOutputStream(fos);                
                }
                else{
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);               
                }
                oos.writeObject(hardwareList.get(i));
                InventoryTable.getItems().add(hardwareList.get(i));
                

            } catch (IOException ex) {
                Logger.getLogger(Packagepkg.Package.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(oos != null) oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Packagepkg.Package.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
               
    }
    
}
