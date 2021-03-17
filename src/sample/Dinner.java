package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Dinner  {
    private String firstname;
    private String surName;
    private boolean isEmployee ;
    private int employeeId;
    private ArrayList<FoodItem> orderList = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("###.##");


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurName() {
        return surName;
    }





    public void addFoodItem(FoodItem foodItem) {
        orderList.add(foodItem);
    }



    public ArrayList<FoodItem> getOrderList() {
        return orderList;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public Dinner(String firstname, String surName, boolean isEmployee) {
        this.firstname = firstname;
        this.surName = surName;
        this.isEmployee = isEmployee;
    }


    @Override
    public String toString() {
        final String formattedString = "%-8s  %3s %5s %1s %8s %1s";
        return (String.format(formattedString,
                firstname,
                surName,
                "\u00A3",
               df.format(getBill()),
                getTotalCfValue(),
                "kcal"
        ));
    }

    public double getBill() {
        double bill = 0;
        for (FoodItem foodItem : orderList) {
          bill += foodItem.getCost();
          }
      if(isEmployee){
          bill = bill - (bill/2);
      }
        return bill;
    }

    public double getTotalCfValue(){
        double totalCfValue = 0;
        for(FoodItem foodItem : orderList){
            totalCfValue += foodItem.getCfValue();

        }
    return totalCfValue;
    }


    public ObservableList<FoodItem> getItemsAsOList() {
        return FXCollections.observableArrayList(orderList);
    }

}