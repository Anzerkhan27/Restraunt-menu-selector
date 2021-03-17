package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;


public class Controller3 implements Initializable {


    public Label totalCfvalue;
    public ListView<FoodItem> orderList;
    public Label customersBill;
    public Label customersCfValue;
    public Label totalCfValue;
    public Label totalBill;
    public Label tableHeading;
    public ListView<Dinner> tableView;
    public Button cashBtn;
    public Button payByCardBtn;

    DecimalFormat decimalFormat = new DecimalFormat("###.##");

    private String tableNo;
    private String noOfDinners;


    private Table table = new Table();

    public void getTableDetails(Table tableList, String tableNo, String noOfDinners) {
        this.table = tableList;
        this.tableNo = tableNo;
        this.noOfDinners = noOfDinners;
        table.setTableNo(Integer.parseInt(tableNo));
        table.setNoOfDinners(Integer.parseInt(noOfDinners));
        tableView.setItems(table);
        this.totalBill.setText("\u00A3" + String.valueOf(decimalFormat.format(table.getTotalTableBill())));
        this.totalCfValue.setText(String.valueOf(table.getTotalCfValue()) + "Kcal");
        tableHeading.setText("TABLE NO: " + table.getTableNo());
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Dinner dinner = tableView.getSelectionModel().getSelectedItem();
                orderList.setItems(dinner.getItemsAsOList());
                customersBill.setText("\u00A3" + String.valueOf(decimalFormat.format(dinner.getBill())));
                customersCfValue.setText(  String.valueOf(dinner.getTotalCfValue() + " Kcal"));
            }
        });
    }

    public void payByCash(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent p = loader.load(getClass().getResource("payByCash.fxml").openStream());
        Scene menu = new Scene(p);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(menu);
        window.show();
    }

    public void payByCard(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent p = loader.load(getClass().getResource("payByCard.fxml").openStream());
        Scene menu = new Scene(p);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(menu);
        window.show();
    }
}



    

