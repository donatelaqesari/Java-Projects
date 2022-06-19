public class Items {
    private String name;
    private double price;
    int index;

    public int getIndex(){
        return this.index;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public Items(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //getter and setter for first member variable
    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        name = firstName;
    }

    //getter and setter for price variable
    public double getPrice() {
        return price;
    }

    public void setPrice(int number) {
        price = number;
    }
}
