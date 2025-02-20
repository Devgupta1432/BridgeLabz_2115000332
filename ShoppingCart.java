import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

    public void addProduct(String name, double price) {
        productPrices.put(name, price);
    }

    public void addToCart(String name, int quantity) {
        if (!productPrices.containsKey(name)) {
            System.out.println("Product not found!");
            return;
        }

        cart.put(name, cart.getOrDefault(name, 0) + quantity);
        double price = productPrices.get(name);

        sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(name);
    }

    public void displayCart() {
        System.out.println("\nItems in Cart (Order Added):");
        cart.forEach((product, quantity) -> 
            System.out.println(product + " x" + quantity + " ($" + productPrices.get(product) + " each)")
        );

        System.out.println("\nItems Sorted by Price:");
        sortedByPrice.forEach((price, products) -> 
            products.forEach(product -> 
                System.out.println(product + " ($" + price + ")")
            )
        );
    }

    public double calculateTotal() {
        return cart.entrySet().stream()
                .mapToDouble(entry -> productPrices.get(entry.getKey()) * entry.getValue())
                .sum();
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 1.0);
        cart.addProduct("Orange", 2.0);
        cart.addProduct("Grapes", 2.5);

        cart.addToCart("Apple", 2);
        cart.addToCart("Banana", 3);
        cart.addToCart("Orange", 1);
        cart.addToCart("Grapes", 2);

        cart.displayCart();
        System.out.println("\nTotal Price: $" + cart.calculateTotal());
    }
}
