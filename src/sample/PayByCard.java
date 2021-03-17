package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PayByCard {
    public Button payBtn;
    public TextField pin;

    public void pay(ActionEvent actionEvent) throws IOException {
        if (checkValidInput()) {
            if (checkValidPin()) {

                FXMLLoader loader = new FXMLLoader();
                Parent p = loader.load(getClass().getResource("payByCash.fxml").openStream());
                Scene menu = new Scene(p);
                Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                window.setScene(menu);
                window.show();
            }
        }
    }

    public Boolean checkValidInput() {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(pin.getText());
        if (m.find() && m.group().equals(pin.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Enter a 4 digit Number");
            alert.showAndWait();
            return false;
        }
    }

    public Boolean checkValidPin() {
        int maxId = 9999;
        int minId = 999;
        if (((Integer.parseInt(pin.getText()) <= maxId && (Integer.parseInt(pin.getText())) > minId))) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Enter a 4 digit Number");
            alert.showAndWait();
            return false;
        }
    }
}