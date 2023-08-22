/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analystpkg;
import customerpkg.Customer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class Survey implements Serializable{
    
    private String QuestionNo;
    private String Question;

    public Survey(String QuestionNo, String Question) {
        this.QuestionNo = QuestionNo;
        this.Question = Question;
    }
    
    
    public static void CreateNewSurvey(Survey c) {
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Survey.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new mainpkg.AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(c);

        } catch (IOException ex) {
            Logger.getLogger(Survey.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Survey.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    

    public String getQuestionNo() {
        return QuestionNo;
    }

    public void setQuestionNo(String QuestionNo) {
        this.QuestionNo = QuestionNo;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }
    
    

    
}
