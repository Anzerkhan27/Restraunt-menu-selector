package sample;


public class FoodItem {
    private String type;
    private  String name;
    private boolean isGlutenFree;
    private boolean isNutFree;
    private double cfValue;
    private double cost;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCfValue() {
        return cfValue;
    }

    public void setCfValue(int cfValue) {
        this.cfValue = cfValue;
    }

    public String getName() {
        return name;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public boolean isNutFree() {
        return isNutFree;
    }

    public FoodItem(String type, String name , double cfValue, double cost, boolean isGlutenFree , boolean isNutFree) {
        this.type = type;
        this.name = name;
        this.cfValue = cfValue;
        this.cost = cost;
        this.isGlutenFree =isGlutenFree;
        this.isNutFree = isNutFree;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        final String formattedString = "%-10s %8s %1s %5s %1s";
        return(String.format(formattedString,
                name,
                cfValue,
                "Kcal",
                "\u00A3",
                cost))
                ;

    }
}