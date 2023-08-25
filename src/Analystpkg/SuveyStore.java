
package Analystpkg;
import java.io.Serializable;

public class SuveyStore implements Serializable {
    private String QuestionNo;
    private String Question;
    private String Answer;

    public SuveyStore(String QuestionNo, String Question, String Answer) {
        this.QuestionNo = QuestionNo;
        this.Question = Question;
        this.Answer = Answer;
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

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }
    
}
