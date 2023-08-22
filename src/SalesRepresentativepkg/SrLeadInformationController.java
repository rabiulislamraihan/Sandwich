
package SalesRepresentativepkg;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SrLeadInformationController implements Initializable {

    @FXML
    private TableView<TableData> tableView;

    @FXML
    private TableColumn<TableData, String> leaderColumn;

    @FXML
    private TableColumn<TableData, String> projectColumn;

    @FXML
    private TableColumn<TableData, LocalDate> startDateColumn;

    @FXML
    private TableColumn<TableData, String> durationColumn;
    @FXML
    private TextField liLeadName;
    @FXML
    private TextField liProjectName;
    @FXML
    private TextField liDuration;
    @FXML
    private DatePicker liStartDate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        leaderColumn.setCellValueFactory(new PropertyValueFactory<TableData,String>("leaderName"));
        projectColumn.setCellValueFactory(new PropertyValueFactory<TableData,String>("projectName"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<TableData,LocalDate>("startDate"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<TableData,String>("duration"));

        loadTableViewData();
    }

    private void loadTableViewData() {
        ObjectInputStream ois = null;
        ObservableList<TableData> data = FXCollections.observableArrayList();
        data.clear();
        tableView.setItems(data);
        try {
             TableData c;
             ois = new ObjectInputStream(new FileInputStream("tableData.bin"));
             
            while(true){
                c = (TableData) ois.readObject();
                tableView.getItems().add(c);
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
    private void addLeadClicked(MouseEvent event) {


        String liLead =  liLeadName.getText();
        String liProject = liProjectName.getText();
        String liDur = liDuration.getText();
        LocalDate liStart = liStartDate.getValue();
        TableData c = new TableData(liLead, liProject, liStart, liDur);

        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("tableData.bin");
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
            Logger.getLogger(TableData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(TableData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void loadButtonClicked(MouseEvent event) {
        loadTableViewData();
    }
}
