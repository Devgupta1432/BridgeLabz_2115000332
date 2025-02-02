class Book1 {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    public Book1(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed: " + title);
        } else {
            System.out.println("Sorry, the book \"" + title + "\" is currently unavailable.");
        }
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        Book1 book1 = new Book1("The Alchemist", "Paulo Coelho", 15.99, true);
        book1.displayDetails();
        book1.borrowBook();
        book1.displayDetails();
    }
}
