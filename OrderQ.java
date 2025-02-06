import java.util.ArrayList;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Customer {
    private String name;
    private ArrayList<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed an order with Order ID: " + order.getOrderId());
    }

    public void viewOrders() {
        System.out.println(name + "'s Orders:");
        for (Order order : orders) {
            order.displayOrderDetails();
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

class Order {
    private static int orderCounter = 1;
    private int orderId;
    private Customer customer;
    private ArrayList<Product> products;

    public Order(Customer customer) {
        this.orderId = orderCounter++;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId + " placed by " + customer.getName());
        System.out.println("Products:");
        double total = 0;
        for (Product product : products) {
            System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
            total += product.getPrice();
        }
        System.out.println("Total Price: $" + total);
        System.out.println();
    }

    public int getOrderId() {
        return orderId;
    }
}

public class OrderQ {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);
        Product product3 = new Product("Headphones", 150.00);

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        Order order1 = new Order(customer1);
        order1.addProduct(product1);
        order1.addProduct(product2);
        customer1.placeOrder(order1);

        Order order2 = new Order(customer2);
        order2.addProduct(product3);
        customer2.placeOrder(order2);

        customer1.viewOrders();
        customer2.viewOrders();
    }
}
