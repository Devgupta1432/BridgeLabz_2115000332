import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

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

public class CarToJson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("Tesla", "Model S", 2023);

        try {
            objectMapper.writeValue(new File("car.json"), car);
            System.out.println("Car JSON created: car.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
