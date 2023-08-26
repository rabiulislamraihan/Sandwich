
package MarketingExecutivepkg;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class BrandVisionAndGuidelinesController implements Initializable {

    @FXML
    private TextArea brandVisionTextArea;
    @FXML
    private TextArea brandGuidelineTextArea;
    @FXML
    private Button BrandVisionButton;
    @FXML
    private Button BrandGuiidlinesButton;
    boolean editableVision = false;
    boolean editableGuidelines = false;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String vision = MarketingExecutive.getvision();
        if(vision == null) {
            BrandVisionButton.setText("Add Brand Vision");
        }
        else {
            brandVisionTextArea.setText(vision);
            BrandVisionButton.setText("Edit Brand Vision");
        }
        String guidelines = MarketingExecutive.getguidelines();
        if(guidelines == null) {
            BrandGuiidlinesButton.setText("Add Brand Guidelines");
        }
        else {
            brandGuidelineTextArea.setText(guidelines);
            BrandGuiidlinesButton.setText("Edit Brand Guidelines");
        }
        brandVisionTextArea.setEditable(false);
        brandGuidelineTextArea.setEditable(false);
        
    }    

    @FXML
    private void BrandVisionButtonOnClick(MouseEvent event) {
        editableVision = !editableVision;
        doSomethingVision();
    }

    @FXML
    private void BrandGuiidlinesButtonOnClick(MouseEvent event) {
        editableGuidelines = !editableGuidelines;
        doSomethingGuidelines();
    }
    
    private void doSomethingVision() {
        if(editableVision) {
            brandVisionTextArea.setEditable(true);
            BrandVisionButton.setText("Save Brand Vision");
        }
        else {
            String vision  = brandVisionTextArea.getText();
            MarketingExecutive.updateBrandVision(vision);
            brandVisionTextArea.setEditable(false);
            BrandVisionButton.setText("Edit Brand Vision");
        }
    }
    
    private void doSomethingGuidelines() {
        if(editableGuidelines) {
            brandGuidelineTextArea.setEditable(true);
            BrandGuiidlinesButton.setText("Save Brand Guidelines");
        }
        else {
            String guidelines  = brandGuidelineTextArea.getText();
            MarketingExecutive.updateBrandGuidelines(guidelines);
            brandGuidelineTextArea.setEditable(false);
            BrandGuiidlinesButton.setText("Edit Brand Guidelines");
        }
    }

    
}
