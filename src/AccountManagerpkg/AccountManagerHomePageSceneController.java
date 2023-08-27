// Hi zaara
package AccountManagerpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class AccountManagerHomePageSceneController implements Initializable {

    @FXML
    private BorderPane BorderPane;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ViewPersonalInformationOnClick(ActionEvent event) throws IOException {

    }

    @FXML
    private void LogoutButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) BorderPane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/mainpkg/SelectUserScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void SalaryDisbursementOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/employeepkg/SalaryDisbursementScene.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }

    @FXML
    private void SeeEmployeeSalaryDetails(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/employeepkg/SeeEmployeeSalaryDetails.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }


    @FXML
    private void balanceSheetButton(ActionEvent event) throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BalanceSheet.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }

    @FXML
    private void incomeStatementButton(ActionEvent event) throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IncomeStatement.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }


    @FXML
    private void budgetAndPerformanceButton(ActionEvent event) throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BudgetAndPerformance.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }

    @FXML
    private void visualizeVarianceButton(ActionEvent event) throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VisualizeBudgetAndPerformance.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }

    @FXML
    private void taxCalculationButton(ActionEvent event) throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TaxManagement.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    
        
    }

    @FXML
    private void analyzeExpensesButton(ActionEvent event) throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ExpensesPieChart.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }

    
}
