
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customerpkg;

import java.io.Serializable;

/**
 *
 * @author Hp
 */
public class Question implements Serializable{
    public int questionNo;
    public String question;

    public Question(int questionNo, String question) {
        this.questionNo = questionNo;
        this.question = question;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
    
    
}
