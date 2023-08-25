/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Technicianpkg;

import java.io.Serializable;

/**
 *
 * @author Hp
 */
public class Answer implements Serializable {
    public int answerNo;
    public String answer;

    public Answer(int answerNo, String answer) {
        this.answerNo = answerNo;
        this.answer = answer;
    }

    public int getAnswerNo() {
        return answerNo;
    }

    public void setAnswerNo(int answerNo) {
        this.answerNo = answerNo;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    
    
}
