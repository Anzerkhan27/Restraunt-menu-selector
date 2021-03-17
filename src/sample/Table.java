package sample;



import com.sun.javafx.collections.ObservableListWrapper;

import javafx.collections.FXCollections;

public class Table extends ObservableListWrapper<Dinner> {
private int tableNo;
private int noOfDinners;
    public Table() {
        super(FXCollections.observableArrayList());
    }


    public void addDinner(String firstName, String surName, boolean isEmployee) {
        super.add(new Dinner(firstName,surName, isEmployee));
    }

   public void removeDinner(Dinner dinner){
        super.remove(dinner);
   }


    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public int getNoOfDinners() {
        return noOfDinners;
    }

    public void setNoOfDinners(int noOfDinners) {
        this.noOfDinners = noOfDinners;
    }

    public Dinner findByFirstName(String name) {
        Dinner temp;
        int indexLocation = -1;
        for (int i = 0; i < super.size(); i++) {
            temp = super.get(i);
            if (temp.getFirstname().equals(name)) {
                indexLocation = i;
                break;
            }
        }

        if (indexLocation == -1) {
            return null;
        } else {
            return super.get(indexLocation);
        }
    }

    public double getTotalTableBill() {
        double bill = 0;
        for (int i = 0; i < super.size(); i++) {
            bill += super.get(i).getBill();

        }
        return bill;
    }

    public double getTotalCfValue() {
        double cfValue = 0;
        for (int i = 0; i < super.size(); i++) {
            cfValue += super.get(i).getTotalCfValue();
        }
        return cfValue;
    }
}