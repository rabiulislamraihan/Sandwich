/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package customerpkg;



import Analystpkg.Survey;
import Analystpkg.SuveyStore;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mainpkg.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class AnswerSurveyController implements Initializable {

    @FXML
    private ComboBox<String> surveysCombobox;
    @FXML
    private TextArea QuestionTextArea;
    @FXML
    private TextArea AnswerTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObjectInputStream ois = null;
        try {
             Survey c;
             ois = new ObjectInputStream(new FileInputStream("Survey.bin"));
             
            while(true){
                c = (Survey) ois.readObject();
                surveysCombobox.getItems().add(c.getQuestionNo());
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
    private void submitAnswerButtonOnClick(MouseEvent event) {
        String questionNo  = surveysCombobox.getValue();
        String answer = AnswerTextArea.getText();
        String question = QuestionTextArea.getText();
        SuveyStore s = new SuveyStore(questionNo,  question, answer);
        SuveyStore.AddSurvey(s);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("Answer Submitted Succesfully");
        a.showAndWait();
        
        
    }

    @FXML
    private void LoadQuestionButtonOnClick(MouseEvent event) {
        String question = surveysCombobox.getValue();
        ObjectInputStream ois = null;
        try {
             Survey c;
             ois = new ObjectInputStream(new FileInputStream("Survey.bin"));
             
            while(true){
                c = (Survey) ois.readObject();
                QuestionTextArea.setText(c.getQuestion());
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
    
}
