abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    
    public double applyDiscount() {
        return calculateTotalPrice() * 0.1;
    }

    
    public String getDiscountDetails() {
        return "Veg item discount: 10%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 5;
    }

    
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    
    public String getDiscountDetails() {
        return "Non-Veg item discount: 5%";
    }
}

public class FoodQ {
    public static void processOrder(FoodItem item) {
        item.getItemDetails();
        System.out.println("Total Price: $" + item.calculateTotalPrice());

        if (item instanceof Discountable) {
            Discountable discountItem = (Discountable) item;
            System.out.println("Discount: $" + discountItem.applyDiscount());
            System.out.println(discountItem.getDiscountDetails());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FoodItem vegBurger = new VegItem("Veg Burger", 5.0, 2);
        FoodItem chickenPizza = new NonVegItem("Chicken Pizza", 10.0, 1);

        FoodItem[] order = {vegBurger, chickenPizza};

        for (FoodItem item : order) {
            processOrder(item);
        }
    }
}
