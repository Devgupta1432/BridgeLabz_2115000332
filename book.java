class book {
    private String title;
    private String author;
    private double price;
    public book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    public book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        book book1 = new book();
        book1.displayBookDetails();

        System.out.println();

        book book2 = new book("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        book2.displayBookDetails();
    }
}
