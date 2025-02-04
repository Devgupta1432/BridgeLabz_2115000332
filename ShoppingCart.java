class Product {
    private static double discount = 10.0;

    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, int productID, double price, int quantity) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            double totalPrice = price * quantity;
            double discountAmount = (totalPrice * discount) / 100;
            double finalPrice = totalPrice - discountAmount;

            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Price: $" + totalPrice);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Final Price after Discount: $" + finalPrice);
            System.out.println("-------------------------");
        }
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public static void displayDiscount() {
        System.out.println("Current Discount: " + discount + "%");
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Product prod1 = new Product("Laptop", 101, 1200.50, 2);
        Product prod2 = new Product("Smartphone", 102, 699.99, 3);

        prod1.displayProductDetails();
        prod2.displayProductDetails();

        Product.displayDiscount();
        Product.updateDiscount(15.0);
        Product.displayDiscount();

        prod1.displayProductDetails();
        prod2.displayProductDetails();
    }
}
