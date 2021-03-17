package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeIdController {
    public TextField employeeId;
    public Button enterBtn;

    private Controller1 parent;

    public void setParent(Controller1 p){
        parent = p;

    }
    public void submitEmployeeId(ActionEvent actionEvent) {
        if (checkValidInput()) {
            if (checkValidId()){
            parent.getEmployeeId(Integer.parseInt(employeeId.getText()));
            ((Stage) enterBtn.getScene().getWindow()).close();
        }
    }}
    public Boolean checkValidInput() {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(employeeId.getText());
        if (m.find() && m.group().equals(employeeId.getText())) {
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
    public Boolean checkValidId() {
        int maxId = 9999;
        int minId = 999;
        if (((Integer.parseInt(employeeId.getText()) <= maxId && (Integer.parseInt(employeeId.getText())) > minId) )) {
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
