/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Analystpkg;

import Analystpkg.Analyst;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class CreateSurveyController implements Initializable {

    @FXML
    private TextArea questionsTextarea;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void CreateQuestionButtonClick(MouseEvent event) {
        String question = questionsTextarea.getText();
        ObjectInputStream ois = null;
        int k = 1;
        try {
             Survey c;
             ois = new ObjectInputStream(new FileInputStream("Survey.bin"));
             
            while(true){
                c = (Survey) ois.readObject();
                k++;
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
        String QuestionNo = "Quetion " + Integer.toString(k++);
        Survey s = new Survey(QuestionNo, question);
        Survey.CreateNewSurvey(s);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("Survey has been created");
        a.showAndWait();
    }
    
}
