abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

interface Reservable {
    boolean reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public Book(int itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }

    
    public int getLoanDuration() {
        return 14;
    }

    
    public boolean reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    
    public boolean checkAvailability() {
        return isAvailable;
    }
}

class Magazine extends LibraryItem {
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    
    public int getLoanDuration() {
        return 7;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public DVD(int itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }

    
    public int getLoanDuration() {
        return 5;
    }

    
    public boolean reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    
    public boolean checkAvailability() {
        return isAvailable;
    }
}

public class LibQ {
    public static void manageLibraryItem(LibraryItem item) {
        item.getItemDetails();
        System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

        if (item instanceof Reservable) {
            Reservable reservableItem = (Reservable) item;
            System.out.println("Availability: " + (reservableItem.checkAvailability() ? "Available" : "Not Available"));
            System.out.println("Reservation Status: " + (reservableItem.reserveItem() ? "Reserved" : "Not Reserved"));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LibraryItem book = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", true);
        LibraryItem magazine = new Magazine(2, "National Geographic", "Various");
        LibraryItem dvd = new DVD(3, "Inception", "Christopher Nolan", true);

        LibraryItem[] items = {book, magazine, dvd};

        for (LibraryItem item : items) {
            manageLibraryItem(item);
        }
    }
}
