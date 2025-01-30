class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
}

public class BookMain {
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 12.50);

        System.out.println("=== Book 1 Details ===");
        book1.displayDetails();

        System.out.println("\n=== Book 2 Details ===");
        book2.displayDetails();
    }
}
