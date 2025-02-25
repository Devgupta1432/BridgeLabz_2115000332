import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student { ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks + " }";
    }
}

public class CSVToObjects {
    public static void main(String[] args) {
        String filePath = Paths.get("src", "main", "resources", "students.csv").toString();
        List<Student> students = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                int id = Integer.parseInt(row[0]);
                String name = row[1];
                int age = Integer.parseInt(row[2]);
                double marks = Double.parseDouble(row[3]);
                students.add(new Student(id, name, age, marks));
            }

            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException | CsvException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
