import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Product {
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1000.00),
                new Product("Phone", 500.00),
                new Product("Tablet", 300.00)
        );

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("products.json"), products);
            System.out.println("Products JSON file created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
