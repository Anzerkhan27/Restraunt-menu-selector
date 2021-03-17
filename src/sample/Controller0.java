package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller0 {
    public TextField tableNo;
    public TextField noOfDinners;
    public Button registerBtn;

    public void goToCustomerDetails(ActionEvent actionEvent) throws IOException {
        if (checkValidInput()) {
            if (checkTableNo()){
                if (checkNoOfDinners()){
            FXMLLoader loader = new FXMLLoader();
            Parent p = loader.load(getClass().getResource("scene1.fxml").openStream());
            Controller1 controller1 = loader.getController();
            controller1.getTableDetails(tableNo.getText(), noOfDinners.getText());
            Scene menu = new Scene(p);
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(menu);
            window.show();
        }}}
    }


    public Boolean checkValidInput() {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(tableNo.getText());
        Matcher m1 = p.matcher(noOfDinners.getText());
        if (m.find() && m.group().equals(tableNo.getText()) && (m1.find() && m1.group().equals(noOfDinners.getText()))) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Input.Enter Positive  Integers");
            alert.showAndWait();
            return false;
        }
    }

    public Boolean checkTableNo() {
        int minTableNo = 0;
        int maxTableNO = 11;
        if (((Integer.parseInt(tableNo.getText()) > minTableNo) && (Integer.parseInt(tableNo.getText()) < maxTableNO))) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Table No.");
            alert.showAndWait();
            return false;

        }

    }

    public Boolean checkNoOfDinners() {
        int minNoOfDinners = 0;
        int maxNoOfDinners = 6;
        if (((Integer.parseInt(noOfDinners.getText()) > minNoOfDinners) && (Integer.parseInt(noOfDinners.getText()) < maxNoOfDinners))) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Invalid No. of Dinners");
            alert.showAndWait();
            return false;
        }
    }
}