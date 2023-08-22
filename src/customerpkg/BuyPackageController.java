
package customerpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import Packagepkg.Package;
import employeepkg.Employee;
import employeepkg.Salary;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
public class BuyPackageController implements Initializable {
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
    private Customer c;
    
    
    public void data (Customer c) {
        this.c = c;
    }
    
    

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
        
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Package c;
             ois = new ObjectInputStream(new FileInputStream("Package.bin"));
             
            while(true){
                c = (Package) ois.readObject();
                if(c.isIsAvailable()) tableView.getItems().add(c);
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
        // TODO
    }    

    @FXML
    private void SeePackageDescriptionOnClick(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Packagepkg/PackageDetails.fxml"));
        
        Parent root = loader.load();
        Package p = tableView.getSelectionModel().getSelectedItem();
//        PackageDetailsController ctrl = loader.getController();
//        ctrl.data(p);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void BuyPackageOnClick(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GenerateAndPayBill.fxml"));
        Parent root = loader.load();
        Package p = tableView.getSelectionModel().getSelectedItem();
        GenerateAndPayBillController ctrl = loader.getController();
        ctrl.data(c, p);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
