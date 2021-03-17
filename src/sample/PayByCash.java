package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PayByCash {

    public Button exitBtn;
    public Button homeBtn;

    public void goToExitScreen(ActionEvent actionEvent) {
        ((Stage)exitBtn.getScene().getWindow()).close();
    }

    public void goToHomeScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent p = loader.load(getClass().getResource("scene0.fxml").openStream());
        Scene menu = new Scene(p);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(menu);
        window.show();
    }
}
