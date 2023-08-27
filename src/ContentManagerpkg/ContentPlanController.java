/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ContentManagerpkg;

import SalesRepresentativepkg.SROrderManagementModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author anika
 */
public class ContentPlanController implements Initializable {

    @FXML
    private CheckBox sun;
    @FXML
    private CheckBox mon;
    @FXML
    private CheckBox tues;
    @FXML
    private CheckBox wed;
    @FXML
    private CheckBox fri;
    @FXML
    private CheckBox thurs;
    @FXML
    private CheckBox sat;
    @FXML
    private ComboBox<String> contentName;
    @FXML
    private TextArea planShow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateComboBox();
        
    }    

    @FXML
    private void saveOnClick(MouseEvent event) {
        String Days="";
        if (sun.isSelected()){
            Days = Days+" "+"Sunday";
        }if (mon.isSelected()){
            Days = Days+" "+"Monday";
        }if (tues.isSelected()){
            Days = Days+" "+"Tuesday";
        }if (wed.isSelected()){
            Days = Days+" "+"Wednesday";
        }if (thurs.isSelected()){
            Days = Days+" "+"Thursday";
        }if (fri.isSelected()){
            Days = Days+" "+"Friday";
        }if (sat.isSelected()){
            Days = Days+" "+"Saturday";
        }if(Days.equals("")){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("You Must Select At Least One Day");
            a.showAndWait();
            return;
        }
        String name = contentName.getValue();
        ContentManager.CreatePlan(name, Days);
        planShow.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Plan.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Plan plan;
            try{
                while(true){
                    plan = (Plan)ois.readObject();
                    planShow.appendText("Content Name: " + plan.name + "\n" +
                            "Days On: " + plan.days + "\n"
                    );
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch                
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        } 
        populateComboBox();
    }
    
    private void populateComboBox() {
        contentName.getItems().clear();
        ArrayList <Schedule> scheduleList = new ArrayList<>();
        ArrayList <Plan> PlanList = new ArrayList<>();
        ObjectInputStream ois = null;
        try{
            Schedule s;
            ois = new ObjectInputStream(new FileInputStream("Schedule.bin"));
            
            while(true){
                s = (Schedule) ois.readObject();
//                contentName.getItems().addAll(s.name);
                    scheduleList.add(s);
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
        ois = null;
        try{
            Plan s;
            ois = new ObjectInputStream(new FileInputStream("Plan.bin"));
            
            while(true){
                s = (Plan) ois.readObject();
                    PlanList.add(s);
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
        
        for (int i = 0; i < scheduleList.size(); i ++) {
            boolean found = false;
            for (int j = 0; j < PlanList.size(); j ++) {
                if(scheduleList.get(i).name.equals(PlanList.get(j).name)) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                contentName.getItems().add(scheduleList.get(i).name);
            }
        }
        
    }
    
}
