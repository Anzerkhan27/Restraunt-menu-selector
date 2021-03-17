package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;



public class Controller2 implements Initializable {


    public ListView<FoodItem> desertsMenu;
    public ListView<FoodItem> mainCourseMenu;
    public Button removeBtn;
    public Button confirmBtn;


    public ListView<FoodItem> menu;
    public ListView selectedList;


    public Button luckyDipButton;
    public Button editMenu;

    public Button glutenFreeBtn;
    public Button nutFreeBtn;
    public ListView<FoodItem> drinksMenu;

    Random random = new Random();


    private String customerFirstName;
    private String customerSurName;
    private String tableNo;
    private String noOfDinners;
    private boolean isEmployee;



    Table table = new Table();


    private static int counter = 0;

    ObservableList<FoodItem> starters = FXCollections.observableArrayList();
    ObservableList<FoodItem> mains = FXCollections.observableArrayList();
    ObservableList<FoodItem> deserts = FXCollections.observableArrayList();
    ObservableList<FoodItem> drinks = FXCollections.observableArrayList();
    ObservableList<FoodItem> selectedOrder;


    FoodItem foodItem = new FoodItem("Starter", "Hummus,Lebanese Dip", 400, 7.99, false, false);
    FoodItem foodItem1 = new FoodItem("Main", "Seafood Paella", 500, 12.00, true, true);
    FoodItem foodItem2 = new FoodItem("Desert", "Pasties De Nata ", 320, 6.6, true, false);
    FoodItem foodItem3 = new FoodItem("Starter", "Mini Pizza Topped with Olive", 400, 7.00, false, true);
    FoodItem foodItem4 = new FoodItem("Main", "Chicken rice", 550, 9.50, true, true);
    FoodItem foodItem5 = new FoodItem("Desert", "Fudge cake", 370, 7.00, false, false);
    FoodItem foodItem6 = new FoodItem("Starter", "Corn Cheese Balls", 400, 7.25, false, true);
    FoodItem foodItem7 = new FoodItem("Main", "Tacos", 580, 10.00, true, true);
    FoodItem foodItem8 = new FoodItem("Desert", "Gulab Jamun", 300, 6.5, true, true);
    FoodItem foodItem9 = new FoodItem("Starter", "Thai Sweet Corn Cutlets", 400, 7, true, true);
    FoodItem foodItem10 = new FoodItem("Main", "Chicken Parm", 600, 13.00, true, false);
    FoodItem foodItem11 = new FoodItem("Desert", "Churros", 400, 8.00, false, false);
    FoodItem foodItem12 = new FoodItem("Starter","Tzatziki Dip",289,6.4,true,false);
    FoodItem foodItem13 = new FoodItem("Starter","Naacho Chips",260,5.00,true,true);
    FoodItem foodItem14 =new FoodItem("Starter","Burata Cheese ",300,7.00,false,true);
    FoodItem foodItem15 = new FoodItem("Starter","Momos",250,5.00,true,true);
    FoodItem foodItem16 = new FoodItem("Starter","Steamed Wontons",270,6.00,false,true);
    FoodItem foodItem17 = new FoodItem("Main","Chilli crab",500,9.00,false,true);
    FoodItem foodItem18 = new FoodItem("Main","Fish'n'Chips",450,8.50,true,true);
    FoodItem foodItem19 =new FoodItem("Main","Fajistas",500,9.00,false,false);
    FoodItem foodItem20 = new FoodItem("Main","Butter Garlic grab",650,12.00,true,true);
    FoodItem foodItem21 = new FoodItem("Main","Lasagna",480,9.00,false,true);
    FoodItem foodItem22 = new FoodItem("Desert","Lamingtons",370,6.50,true,true);
    FoodItem foodItem23 = new FoodItem("Desert","Malva Pudding",320,7.20,true,true);
    FoodItem foodItem24 = new FoodItem("Desert","Rum Cake",400,5.50,true,true);
    FoodItem foodItem25 =new FoodItem("Deserts","Baklava",300,6.00,false,false);
    FoodItem foodItem26 = new FoodItem("Deserts","Black Forest",400,7.00,true,false);
    FoodItem foodItem27 = new FoodItem("Deserts","Borma",380,6.00,false,true);
    FoodItem foodItem28 = new FoodItem("Drinks","Pisco Sour",100,1.00,false,false);
    FoodItem foodItem29 = new FoodItem("Drinks","Bia Hoi",80,0.80,false,false);
    FoodItem foodItem30 =new FoodItem("Drinks","Sake",90,1.00,false,false);
    FoodItem foodItem31 = new FoodItem("Drinks","Campari",70,1.20,false,false);
    FoodItem foodItem32 = new FoodItem("Drinks","Bourbon",78,.60,false,false);

    ObservableList<FoodItem> orderList = FXCollections.observableArrayList(foodItem, foodItem1, foodItem2,foodItem3, foodItem4, foodItem5,
            foodItem6, foodItem7, foodItem8, foodItem9, foodItem10, foodItem11,
            foodItem12,foodItem13,foodItem14,foodItem15,foodItem16,foodItem17,
            foodItem18,foodItem19,foodItem20,foodItem21,foodItem22,foodItem23,foodItem24,foodItem25,
            foodItem26,foodItem27,foodItem28,foodItem29,foodItem30,foodItem31,foodItem32);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (FoodItem foodItem : orderList) {
            if (foodItem.getType().equals("Starter")) {
                starters.add(foodItem);
            } else if (foodItem.getType().equals("Main")) {
                mains.add(foodItem);
            } else if (foodItem.getType().equals("Desert")){
                deserts.add(foodItem);
            }
            else {
                drinks.add(foodItem);
            }

        }

        menu.setItems(starters);
        mainCourseMenu.setItems(mains);
        desertsMenu.setItems(deserts);
        selectedOrder = FXCollections.observableArrayList();
        selectedList.setItems(selectedOrder);
        drinksMenu.setItems(drinks);

        menu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (menu.getSelectionModel().getSelectedIndex() == -1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("NO MEAL SELECTED");
                    alert.setHeaderText(null);
                    alert.setContentText("Please Select a Meal");
                    alert.showAndWait();
                } else {
                    FoodItem foodItem = menu.getSelectionModel().getSelectedItem();
                    selectedOrder.add(foodItem);
                }
            }
        }

        );
        mainCourseMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if(mainCourseMenu.getSelectionModel().getSelectedIndex() == -1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("NO MEAL SELECTED");
                    alert.setHeaderText(null);
                    alert.setContentText("Please Select a Meal");
                    alert.showAndWait();
                }else {
                    FoodItem foodItem = mainCourseMenu.getSelectionModel().getSelectedItem();
                selectedOrder.add(foodItem);
            }}
        });

        desertsMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (desertsMenu.getSelectionModel().getSelectedIndex() == -1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("NO MEAL SELECTED");
                    alert.setHeaderText(null);
                    alert.setContentText("Please Select a Meal");
                    alert.showAndWait();
                } else {
                    FoodItem foodItem = desertsMenu.getSelectionModel().getSelectedItem();
                    selectedOrder.add(foodItem);
                }

            }

            }

            );

drinksMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        if (drinksMenu.getSelectionModel().getSelectedIndex()== -1){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("NO MEAL SELECTED");
            alert.setHeaderText(null);
            alert.setContentText("Please Select a Meal");
            alert.showAndWait();
        }
    else {
            FoodItem foodItem = drinksMenu.getSelectionModel().getSelectedItem();
            selectedOrder.add(foodItem);
        }
    }
});
    }






    public void confirmOrder(ActionEvent actionEvent) throws IOException {
        if(checkDinnerOrder()) {
            table.addDinner(customerFirstName, customerSurName, isEmployee);
            Dinner dinner = table.findByFirstName(customerFirstName);
            for (FoodItem foodItem : selectedOrder) {
                dinner.addFoodItem(foodItem);
            }
            counter = counter + 1;
            if (counter < Integer.parseInt(noOfDinners)) {
                FXMLLoader loader = new FXMLLoader();
                Parent p = loader.load(getClass().getResource("scene1.fxml").openStream());
                Controller1 controller1 = loader.getController();
                controller1.getDetails(table, tableNo, noOfDinners);
                Scene menu = new Scene(p);
                Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                window.setScene(menu);
                window.show();
            } else {
                FXMLLoader loader = new FXMLLoader();
                Parent p = loader.load(getClass().getResource("scene3.fxml").openStream());
                Controller3 controller3 = loader.getController();
                controller3.getTableDetails(table, tableNo, noOfDinners);
                Scene menu = new Scene(p);
                Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                window.setScene(menu);
                window.show();
            }
        }
    }
    public void luckyDrinkMeal(ActionEvent event) {
        int shuffle = random.nextInt(starters.size());
        menu.getSelectionModel().select(shuffle);
        int element = menu.getSelectionModel().getSelectedIndex();
        FoodItem item = starters.get(element);
        selectedOrder.add(item);
        int shuffle1 = random.nextInt(mains.size());
        mainCourseMenu.getSelectionModel().select(shuffle1);
        int element1 = mainCourseMenu.getSelectionModel().getSelectedIndex();
        FoodItem item1 = mains.get(element1);
        selectedOrder.add(item1);
        int shuffle2 = random.nextInt(deserts.size());
        desertsMenu.getSelectionModel().select(shuffle2);
        int element2 = desertsMenu.getSelectionModel().getSelectedIndex();
        FoodItem item2 = deserts.get(element2);
        selectedOrder.add(item2);
        int shuffle3 = random.nextInt(drinks.size());
        drinksMenu.getSelectionModel().select(shuffle3);
        int element3 = drinksMenu.getSelectionModel().getSelectedIndex();
        FoodItem item3 = drinks.get(element3);
        selectedOrder.add(item3);
    }


    public void editMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editMenu.fxml"));
        Scene scene = new Scene(loader.load());
        EditMenuController editMenuController = loader.getController();
        editMenuController.setParent(Controller2.this);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }


    public void getCustomerDetails(String tableNo, String customerFirstName, String customerSurName, String noOfDinners, boolean isEmployee,Table tableList) {
        this.tableNo = tableNo;
        this.customerFirstName = customerFirstName;
        this.customerSurName = customerSurName;
        this.noOfDinners = noOfDinners;
        this.isEmployee = isEmployee;
        this.table = tableList;
    }

    public void showGlutenFree(ActionEvent actionEvent) {
        starters.removeIf(o -> !o.isGlutenFree());
        mains.removeIf(o1 -> !o1.isGlutenFree());
        deserts.removeIf(o2 -> !o2.isGlutenFree());
        drinks.removeIf(o2 -> !o2.isGlutenFree());
                    }

   public void addFoodItem(String type , double cfValue , double price , String name,boolean isGlutenFree , boolean isNutFree) {
       if (type.equals("Starters")) {
           starters.add(new FoodItem(type, name, cfValue, price, isGlutenFree, isNutFree));
       } else if (type.equals("Main")) {
           mains.add(new FoodItem(type, name, cfValue, price, isGlutenFree, isNutFree));
       } else if (type.equals("Desert")) {
           deserts.add(new FoodItem(type, name, cfValue, price, isGlutenFree, isNutFree));
       } else if (type.equals("Drink")){
           drinks.add(new FoodItem(type, name, cfValue, price, isGlutenFree, isNutFree));
       }
   }
    public void showNutFree(ActionEvent actionEvent) {
        starters.removeIf(o -> !o.isNutFree());
        mains.removeIf(o1 -> !o1.isNutFree());
        deserts.removeIf(o2 -> !o2.isNutFree());
        drinks.removeIf(o2 -> !o2.isNutFree());
    }

    public void removeFoodItem(ActionEvent actionEvent) {
       if(checkDinnerOrder()) {
           FoodItem foodItem = (FoodItem) selectedList.getSelectionModel().getSelectedItem();
           selectedOrder.remove(foodItem);
       }

    }
    public Boolean checkDinnerOrder(){
        if (selectedOrder.size() > 0){
            return true;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("NO MEAL SELECTED");
            alert.setHeaderText(null);
            alert.setContentText("At Least Select one Item");
            alert.showAndWait();
         return false;
        }
    }



}








