abstract class Product<T> {
    T category;
    double price;
    
    Product(T category, double price) {
        this.category = category;
        this.price = price;
    }
    
    abstract void display();
}

class BookCategory {
    String categoryName = "Books";
}

class ClothingCategory {
    String categoryName = "Clothing";
}

class GadgetCategory {
    String categoryName = "Gadgets";
}

class Book extends Product<BookCategory> {
    Book(double price) {
        super(new BookCategory(), price);
    }

    void display() {
        System.out.println("Book Price: $" + price);
    }
}

class Clothing extends Product<ClothingCategory> {
    Clothing(double price) {
        super(new ClothingCategory(), price);
    }

    void display() {
        System.out.println("Clothing Price: $" + price);
    }
}

class Gadget extends Product<GadgetCategory> {
    Gadget(double price) {
        super(new GadgetCategory(), price);
    }

    void display() {
        System.out.println("Gadget Price: $" + price);
    }
}

class Marketplace {
    <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.price -= product.price * (percentage / 100);
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        Book book = new Book(30);
        Clothing clothing = new Clothing(50);
        Gadget gadget = new Gadget(150);
        
        Marketplace marketplace = new Marketplace();
        
        book.display();
        marketplace.applyDiscount(book, 10);
        book.display();
        
        clothing.display();
        marketplace.applyDiscount(clothing, 15);
        clothing.display();
        
        gadget.display();
        marketplace.applyDiscount(gadget, 20);
        gadget.display();
    }
}
