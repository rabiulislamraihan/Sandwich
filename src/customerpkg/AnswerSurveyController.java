
package customerpkg;



import Analystpkg.Analyst;
import Analystpkg.Survey;
import Analystpkg.SuveyStore;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import mainpkg.PopUp;


public class AnswerSurveyController implements Initializable {

    @FXML
    private ComboBox<String> surveysCombobox;
    @FXML
    private TextArea QuestionTextArea;
    @FXML
    private TextArea AnswerTextArea;
    private ArrayList<Survey> surveyList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        surveyList = Analyst.GetSurveyList();
        for (int i = 0; i < surveyList.size(); i ++) {
            surveysCombobox.getItems().add(surveyList.get(i).getQuestionNo());
        }
    }    
    
    @FXML
    private void submitAnswerButtonOnClick(MouseEvent event) {
        String questionNo  = surveysCombobox.getValue();
        String answer = AnswerTextArea.getText();
        String question = QuestionTextArea.getText();
        SuveyStore s = new SuveyStore(questionNo,  question, answer);
        Analyst.AddSurvey(s);
        PopUp.Message("Answer Submitted Succesfully");
    }

    @FXML
    private void LoadQuestionButtonOnClick(MouseEvent event) {
        surveyList = Analyst.GetSurveyList();
        for (int i = 0; i < surveyList.size(); i ++) {
            if(surveyList.get(i).getQuestionNo().equals(surveysCombobox.getValue())) {
                QuestionTextArea.setText(surveyList.get(i).getQuestion());
            }
        }
    }
}
