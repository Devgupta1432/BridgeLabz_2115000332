class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {

    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayEBookDetails() {
        System.out.println("EBook Details:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
    }
}

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("123-456-789", "Java Programming", "John Doe");
        book1.displayBookDetails();
        book1.setAuthor("Jane Smith");
        System.out.println("\nAfter modifying author:");
        book1.displayBookDetails();

        System.out.println("\nEBook Details:");
        EBook eBook1 = new EBook("987-654-321", "Advanced Java", "Mark Johnson");
        eBook1.displayEBookDetails();
    }
}
