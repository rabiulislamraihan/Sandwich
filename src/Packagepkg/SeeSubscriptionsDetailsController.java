/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Packagepkg;

import Administratorpkg.Administrator;
import customerpkg.Customer;
import customerpkg.GenerateAndPayBillController;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class SeeSubscriptionsDetailsController implements Initializable {

    @FXML
    private TableView<Subscriptions> tableView;
    @FXML
    private TableColumn<Subscriptions, String> pid;
    @FXML
    private TableColumn<Subscriptions, String> pname;
    @FXML
    private TableColumn<Subscriptions, String> purchaseDate;
    @FXML
    private TableColumn<Subscriptions, String> expiryDate;
    @FXML
    private TableColumn<Subscriptions, String> days;
    @FXML
    private TableColumn<Subscriptions, String> price;
    @FXML
    private TableColumn<Subscriptions, String> tID;
    
    private Customer c;
    
    public void data(Customer c) {
        this.c = c;
        tableView.getItems().clear();
        tableView.getItems().addAll(Administrator.getSubscriptionsList(c));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        pid.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getPackageID());});
        pname.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getPackageName());} );    
        purchaseDate.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getPurchasedate().toString());});     
        expiryDate.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getExpirydate().toString());} );    
        days.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(Long.toString(cellData.getValue().getRemainigdays()));} ) ;      
        price.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(Integer.toString(cellData.getValue().getPrice()));}) ;      
        tID.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(Integer.toString(cellData.getValue().getTransactionID()));} );       
        
        
        // TODO
    }    

    @FXML
    private void SeeBillButtonOnClick(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SeeBill.fxml"));
        Parent root = loader.load();
        Subscriptions p = tableView.getSelectionModel().getSelectedItem();
        SeeBillController ctrl = loader.getController();
        ctrl.data(p);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
