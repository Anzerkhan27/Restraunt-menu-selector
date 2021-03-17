package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
;

public class EditMenuController implements Initializable {


    public RadioButton drinkButton;
    String string = " ";
    public TextField orderName;
    public TextField cdValue;
    public TextField price;
    public RadioButton starterButton;
    public RadioButton mainCourseButton;
    public RadioButton desertButton;
    public Button addOrderButton;
    public Button exitButton;
    public CheckBox glutenFreeBox;
    public CheckBox nutFreeCheckBox;
    private ToggleGroup orderType;

    private Controller2 parent;
    private boolean isGlutenFree = false;
    private boolean isNutFree = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderType = new ToggleGroup();
        starterButton.setToggleGroup(orderType);
        mainCourseButton.setToggleGroup(orderType);
        desertButton.setToggleGroup(orderType);
        drinkButton.setToggleGroup(orderType);


    }


    public void setParent(Controller2 p) {
        parent = p;
    }

    public void exit(ActionEvent event) {
        ((Stage) exitButton.getScene().getWindow()).close();

    }

    public void orderTypeBtnChanged(ActionEvent event) {
        if (orderType.getSelectedToggle().equals(starterButton)) {
            string = "Starter";
        }
        if (orderType.getSelectedToggle().equals(mainCourseButton)) {
            string = "Main";
        }
        if (orderType.getSelectedToggle().equals(desertButton)) {
            string = "Desert";
        }
        if (orderType.getSelectedToggle().equals(drinkButton)) {
            string = "Drink";
        }
    }
    public void addFoodItem(ActionEvent actionEvent) {
        if (checkEmptyFields()) {
            try {
                 {
                    if (checkOrderType()) {
                        parent.addFoodItem(string, Double.parseDouble(cdValue.getText()),
                                Double.parseDouble(price.getText()), orderName.getText(), isGlutenFree, isNutFree);
                        ((Stage) addOrderButton.getScene().getWindow()).close();

                    }
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Invalid input");
                alert.showAndWait();
            }
        }
    }


    public void isGlutenFree(ActionEvent actionEvent) {
             isGlutenFree = true;
    }

    public void isNutFree(ActionEvent actionEvent) {
        isNutFree = true;
     }

    public Boolean checkEmptyFields() {
        if (orderName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("FILL ALL THE FIELDS");
            alert.showAndWait();
            return false;

        }
        return true;
    }



public boolean checkOrderType(){
        if(string == " "){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("SELECT A ORDER TYPE");
            alert.showAndWait();
            return false;
        }
        else {
            return true;
        }
}

}