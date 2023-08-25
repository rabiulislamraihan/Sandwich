
package SalesRepresentativepkg;

import Administratorpkg.Administrator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import Packagepkg.Package;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class DeletePackageController implements Initializable {
    @FXML
    private TableView<Package> tableView;
    @FXML
    private TableColumn<Package, String> codeColumn;
    @FXML
    private TableColumn<Package, String> titleColumn;
    @FXML
    private TableColumn<Package, Integer> durationColumn;
    @FXML
    private TableColumn<Package, Integer> priceColumn;
    

    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        codeColumn.setCellValueFactory(new PropertyValueFactory<Package,String>("Code"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Package,String>("Title"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<Package,Integer>("Duration"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Package,Integer>("Price"));
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        loadTable();
        
        // TODO
    }    



    @FXML
    private void DeletePackageOnClick(MouseEvent event) throws IOException {
        Package p = tableView.getSelectionModel().getSelectedItem();
        Administrator.deleteItem(p);
        loadTable();

    }
    
    private void loadTable () {
        ObservableList <Package> list = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Package c;
             ois = new ObjectInputStream(new FileInputStream("Package.bin"));
             
            while(true){
                c = (Package) ois.readObject();
                if(c.isIsAvailable()) list.add(c);
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
        tableView.setItems(list);
        
    }
    
}
