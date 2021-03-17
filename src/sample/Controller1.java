package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller1 implements Initializable {
    public TextField txtField1;
    public TextField txtxField2;
    public Button MenuBtn;
    public Label tableNumber;
    public Label dinnerNumber;
    public CheckBox employeeCheckBox;
    public Label numberOfDinners;


    private String tableNo;
    private String noOfDinners;
    private boolean isEmployee;
    private int employeeId;

    private static int dinnerCounter = 1;


    Table table = new Table();


    public void goToMenu(ActionEvent event) throws IOException {
        dinnerCounter += 1;
        if (checkEmptyFields()) {
            FXMLLoader loader = new FXMLLoader();
            Parent p = loader.load(getClass().getResource("scene2.fxml").openStream());
            Controller2 controller = loader.getController();
            controller.getCustomerDetails(tableNo, txtField1.getText(), txtxField2.getText(), noOfDinners, isEmployee, table);
            Scene menu = new Scene(p,1200,840);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(menu);
            window.show();
        }
    }

    public void getTableDetails(String tableNo, String noOfDinners) {
        this.tableNo = tableNo;
        this.noOfDinners = noOfDinners;
        this.tableNumber.setText("TABLE NO: " + tableNo);
        this.numberOfDinners.setText("NO. Of Dinners: " + noOfDinners);
    }

    public void getDetails(Table tableList, String tableNo, String noOfDinners) {
        table = tableList;
        this.tableNo = tableNo;
        this.noOfDinners = noOfDinners;
        this.tableNumber.setText("TABLE N0: " + tableNo);
        this.numberOfDinners.setText("NO OF DINNERS: " + noOfDinners);
    }


    public void isEmployee(ActionEvent actionEvent) throws IOException {
        isEmployee = true;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("employeeId.fxml"));
        Scene scene = new Scene(loader.load());
        EmployeeIdController studentIdController = loader.getController();
        studentIdController.setParent(Controller1.this);
        Stage stage = new Stage();
        stage.setTitle("ENTER EMPLOYEE ID ");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dinnerNumber.setText("Welcome Dinner " + dinnerCounter);


    }

    public void getEmployeeId(int studentId) {
        this.employeeId = studentId;


    }
    public Boolean checkEmptyFields() {
        if (txtField1.getText().isEmpty() | txtxField2.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("ENTER FULL DETAILS");
            alert.showAndWait();
            return false;

        }
        return true;
    }

}