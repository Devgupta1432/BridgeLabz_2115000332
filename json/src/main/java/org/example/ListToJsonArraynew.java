import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Car {
    public String brand;
    public String model;
    public int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

public class ListToJsonArraynew {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("Toyota", "Camry", 2022),
                new Car("Honda", "Civic", 2021),
                new Car("Ford", "Mustang", 2023)
        );

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("src/main/resources/cars.json"), cars);
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + e.getMessage());
        }
    }
}
