
package customerpkg;

import Administratorpkg.Administrator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import Packagepkg.Package;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        codeColumn.setCellValueFactory(new PropertyValueFactory<Package,String>("Code"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Package,String>("Title"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<Package,Integer>("Duration"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Package,Integer>("Price"));
            
        ObservableList <Package> list = Administrator.getPackagelist();
        tableView.getItems().addAll(list);
        
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
