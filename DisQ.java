abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
    }
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    
    public double calculateDiscount() {
        return getPrice() * 0.1;
    }

    
    public double calculateTax() {
        return getPrice() * 0.15;
    }

    
    public String getTaxDetails() {
        return "Electronics tax: 15%";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    
    public double calculateDiscount() {
        return getPrice() * 0.2;
    }

    
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    
    public String getTaxDetails() {
        return "Clothing tax: 5%";
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class DisQ {
    public static void calculateFinalPrice(Product product) {
        double discount = product.calculateDiscount();
        double tax = product instanceof Taxable ? ((Taxable) product).calculateTax() : 0;
        double finalPrice = product.getPrice() + tax - discount;

        product.displayDetails();
        System.out.println("Discount: $" + discount);
        System.out.println("Tax: $" + tax);
        System.out.println("Final Price: $" + finalPrice);
        System.out.println();
    }

    public static void main(String[] args) {
        Product laptop = new Electronics(1, "Laptop", 1000);
        Product tshirt = new Clothing(2, "T-Shirt", 50);
        Product apple = new Groceries(3, "Apple", 5);

        Product[] products = {laptop, tshirt, apple};

        for (Product product : products) {
            calculateFinalPrice(product);
        }
    }
}
