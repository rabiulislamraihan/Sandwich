/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Analystpkg;

import customerpkg.Customer;
import employeepkg.Employee;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class SurveyResultsController implements Initializable {

    @FXML
    private ComboBox<String> selectQuestionComboBox;
    @FXML
    private TableView<SuveyStore> tableView;
    @FXML
    private TableColumn<SuveyStore, String> answerColumn;
    @FXML
    private TextArea QuestionTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObjectInputStream ois = null;
        try {
             Survey c;
             ois = new ObjectInputStream(new FileInputStream("Survey.bin"));
             
            while(true){
                c = (Survey) ois.readObject();
                selectQuestionComboBox.getItems().add(c.getQuestionNo());
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
        answerColumn.setCellValueFactory(new PropertyValueFactory<SuveyStore, String>("Answer"));

    }    

    @FXML
    private void viewAnswersOnClick(MouseEvent event) {
        String questionNo = selectQuestionComboBox.getValue();
        
        
        ObjectInputStream ois = null;
        try {
             Survey c;
             ois = new ObjectInputStream(new FileInputStream("Survey.bin"));
             
            while(true){
                c = (Survey) ois.readObject();
                QuestionTextArea.setText(c.getQuestion());
                break;
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
        
        ois = null;
        try {
             SuveyStore c;
             ois = new ObjectInputStream(new FileInputStream("SuveyStore.bin"));
             
            while(true){
                c = (SuveyStore) ois.readObject();
                if(c.getQuestionNo().equals(questionNo)) {
                    tableView.getItems().add(c);
                }
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
