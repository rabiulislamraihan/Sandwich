/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package customerpkg;

//import Technicianpkg.AppendableObjectOutputStream;

import Analystpkg.Survey;
import Technicianpkg.Answer;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mainpkg.AppendableObjectOutputStream;



/**
 * FXML Controller class
 *
 * @author Hp
 */
public class AskQuestionController implements Initializable {

    @FXML
    private TextField questionTextfield;
    @FXML
    private ComboBox<Integer> selectQuestionCombobox;

   
    @FXML
    private TextArea answerTextarea;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObjectInputStream ois = null;
        try {
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
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        
    }    

    @FXML
    private void submitQuestionOnCLick(ActionEvent event) {
        
        String question = questionTextfield.getText();
       
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
//        added
        ObjectInputStream ois = null;
        int qNo = 1;
        try {
             Question q;
             ois = new ObjectInputStream(new FileInputStream("Question.bin"));
             
            while(true){
                q = (Question) ois.readObject();
                qNo++;
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
//        end
        
        try {
            f = new File("Question.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            Question q = new Question(qNo, question); 
            System.out.println(q.question);
            System.out.println(q.questionNo);
            oos.writeObject(q);
            System.out.println(q.questionNo);

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Question has been added!" );
            a.showAndWait();
            
            
            selectQuestionCombobox.getItems().addAll(q.getQuestionNo());
            
            
        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        
        
        
    }

    @FXML
    private void loadAnswerOnCLick(ActionEvent event) {
        
        
         ObjectInputStream ois = null;

        try{
            Answer a;
            ois = new ObjectInputStream(new FileInputStream("Answer.bin"));
            
            while(true){
                a = (Answer) ois.readObject();
                if(a.getAnswerNo() == selectQuestionCombobox.getValue()){
                    answerTextarea.setText(a.getAnswer());
                    
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
    
}
