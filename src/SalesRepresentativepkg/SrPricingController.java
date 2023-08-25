
package SalesRepresentativepkg;

import Administratorpkg.Administrator;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import Packagepkg.Package;


/**
 * FXML Controller class
 *
 * @author anika
 */
public class SrPricingController implements Initializable {

    @FXML
    private TextField pmNewPrice;
    @FXML
    private ComboBox<String> pmPackage;
    @FXML
    private TextArea pmShow;
    @FXML
    private TextField pmOriginalPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObjectInputStream ois = null;
        try {
             Package c;
             ois = new ObjectInputStream(new FileInputStream("Package.bin"));
             
            while(true){
                c = (Package) ois.readObject();
                pmPackage.getItems().add(c.getTitle());
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
    private void pmSaveChanges(MouseEvent event) {
        int newPrice = Integer.parseInt(pmNewPrice.getText());
        pmOriginalPrice.setText(Integer.toString((newPrice)));
        Package p = Package.getInstance(pmPackage.getValue());
        pmShow.setText("Previous Price: " + p.getPrice() + "\n" + 
                "Current Price: " + newPrice);
        Administrator.UpdatePrice(p, newPrice);
    }


    @FXML
    private void pmPackageClicked(ActionEvent event) {
        Package p = Package.getInstance(pmPackage.getValue());
        pmOriginalPrice.setText(Integer.toString(p.getPrice()));
    }
}
    

