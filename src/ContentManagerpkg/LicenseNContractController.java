/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ContentManagerpkg;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author anika
 */
public class LicenseNContractController implements Initializable {

    @FXML
    private TableView<License> tableView;
    @FXML
    private TableColumn<License, String> licenseTitle;
    @FXML
    private TableColumn<License, String> contractorName;
    @FXML
    private TableColumn<License, String> status;
    @FXML
    private TextField licenseTitleT;
    @FXML
    private TextField nameT;
    @FXML
    private ComboBox<String> activeStatusCB;
    @FXML
    private TextArea licenseDescription;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        activeStatusCB.getItems().addAll("Active", "Inactive","Undefined");
        licenseTitle.setCellValueFactory(new PropertyValueFactory<License,String>("LicenseTitle"));
        contractorName.setCellValueFactory(new PropertyValueFactory<License,String>("ContractorName"));
        status.setCellValueFactory(new PropertyValueFactory<License,String>("ActiveStatus"));
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        loadTableViewData();
        
    }    
    private void loadTableViewData() {
        ObjectInputStream ois = null;
        ObservableList<License> data = FXCollections.observableArrayList();
        data.clear();
        tableView.setItems(data);
        try {
             License c;
             ois = new ObjectInputStream(new FileInputStream("License.bin"));
             
            while(true){
                c = (License) ois.readObject();
                tableView.getItems().add(c);
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
    private void addLicenseOnClick(MouseEvent event) {
        int x=0;
        String title = licenseTitleT.getText();
        String name = nameT.getText();
        String status = activeStatusCB.getValue();
        String description = licenseDescription.getText();
        if ("".equals(description)){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("There must be Description.");
            a.showAndWait();
            x=1;
        }if ("".equals(title)){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("There must be Title.");
            a.showAndWait();
            x=1;
        }if ("".equals(status)){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("There must be Status.");
            a.showAndWait();
            x=1;
        }if ("".equals(name)){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("There must be Name.");
            a.showAndWait();
            x=1;
        }
        if (x==1){
            return;
        }
        String[] s = name.split("\\s+");
        int z=0;
        for (int i=0; i<s.length; i++){
        if(ContentManager.isAlpha(s[i])==false){
            z=1;
        }}if(z==1){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("The Name must consist of Only alphabets.");
            a.showAndWait();
            return;
        }
        License c = new License(title, name, status, description);

        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("License.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new mainpkg.AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(c);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("License has been added");
            a.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(License.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(License.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        loadTableViewData();
    }

    @FXML
    private void seeDescriptionOnClick(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LicenseDetails.fxml"));
        Parent root = loader.load();
        License p = tableView.getSelectionModel().getSelectedItem();
        if (p==null){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("You must select ONE License to view it's description.");
            a.showAndWait();
            return;
        }
        LicenseDetailsController ctrl = loader.getController();
        ctrl.data(p);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
