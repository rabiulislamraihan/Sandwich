/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Technicianpkg;

import customerpkg.Question;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class AnswerQueriesController implements Initializable {

    @FXML
    private ComboBox<Integer> selectQuestionCombobox;
    @FXML
    private Label questionLabel;
    @FXML
    private TextArea answerTextarea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObjectInputStream ois = null;

        try{
            Question q;
            ois = new ObjectInputStream(new FileInputStream("Question.bin"));
            
            while(true){
                q = (Question) ois.readObject();
                selectQuestionCombobox.getItems().add(q.questionNo);
                
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            try {
                if(ois!=null){
                    ois.close();
                }
            }
            catch (IOException ex1){ }
        }
       
        
    }    

    @FXML
    private void loadQuestionOnClick(ActionEvent event) {
        
     ObjectInputStream ois = null;

        try{
            Question q;
            ois = new ObjectInputStream(new FileInputStream("Question.bin"));
            
            while(true){
                q = (Question) ois.readObject();
                if(q.questionNo == selectQuestionCombobox.getValue()){
                    questionLabel.setText(q.getQuestion());
                    return;
                }
                
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            try {
                if(ois!=null){
                    ois.close();
                }
            }
            catch (IOException ex1){ }
        }
        
        
        
    }

    @FXML
    private void submitAnswerOnClick(ActionEvent event) {
        
        
        File s = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
   
        
        try {
            s = new File("Answer.bin");
            if(s.exists()){
                fos = new FileOutputStream(s,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(s);
                oos = new ObjectOutputStream(fos);               
            }
            
            String answer = answerTextarea.getText();
            Answer a = new Answer(selectQuestionCombobox.getValue(), answer);

           oos.writeObject(a);


        } catch (IOException ex) {
            Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
        
        
    }
    
}
