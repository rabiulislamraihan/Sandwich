package Packagepkg;
import Administratorpkg.Administrator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import mainpkg.PopUp;

public class AddNewPackageController implements Initializable {

    @FXML
    private TextField titleTextfield;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private ComboBox<Integer> durationComboBox;
    @FXML
    private TextField codeTextField;
    @FXML
    private RadioButton availableRadioButton;
    @FXML
    private RadioButton notAvailableRadioButton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg = new ToggleGroup();
        availableRadioButton.setToggleGroup(tg);
        notAvailableRadioButton.setToggleGroup(tg);
        durationComboBox.getItems().addAll(1,  2, 3, 6,  12, 24);
    }    

    @FXML
    private void AddPackageButtonOnClick(MouseEvent event) {
        boolean available = true;
        if(notAvailableRadioButton.isSelected()) available = false;
        
        String title = titleTextfield.getText();
        int price = Integer.parseInt(priceTextField.getText());
        String description = descriptionTextArea.getText();
        int duration = durationComboBox.getValue();
        String code = codeTextField.getText();
        Package p = new Package(title, duration, price, description, code, available);
        if(!Package.checkPackageexistence(p)){
            Administrator.AddNewPackage(p);
            PopUp.Message("Package Added Succesfully !");
        }
        else {
            PopUp.Message("Package already exists !");
        }
    }
    
}
