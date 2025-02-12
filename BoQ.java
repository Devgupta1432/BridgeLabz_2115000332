class BookNode {
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    public BookNode(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    BookNode head;

    public void inB(String title, String author, String genre, int bookID, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    public void inE(String title, String author, String genre, int bookID, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = newNode;
            return;
        }
        BookNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
    }

    public void inS(String title, String author, String genre, int bookID, boolean isAvailable, int p) {
        if (p == 1) {
            inB(title, author, genre, bookID, isAvailable);
            return;
        }
        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        BookNode temp = head;
        for (int i = 1; i < p - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid Position!");
            return;
        }
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void delB() {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    public void delE() {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        BookNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    public void delS(int bookID) {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        if (head.bookID == bookID) {
            delB();
            return;
        }
        BookNode temp = head;
        while (temp != null && temp.bookID != bookID) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book not found!");
            return;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    public boolean search(String title, String author) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title) || temp.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found: " + temp.title + " | Author: " + temp.author + " | Genre: " + temp.genre + " | ID: " + temp.bookID + " | Available: " + temp.isAvailable);
                return true;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
        return false;
    }

    public void modifyAvailability(int bookID, boolean isAvailable) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.isAvailable = isAvailable;
                System.out.println("Availability updated for book ID: " + bookID + " to " + (isAvailable ? "Available" : "Not Available"));
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    public int countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void displayForward() {
        BookNode curr = head;
        while (curr != null) {
            System.out.println("Book: " + curr.title + " | Author: " + curr.author + " | Genre: " + curr.genre + " | ID: " + curr.bookID + " | Available: " + curr.isAvailable);
            curr = curr.next;
        }
    }

    public void displayBackward() {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        BookNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        while (last != null) {
            System.out.println("Book: " + last.title + " | Author: " + last.author + " | Genre: " + last.genre + " | ID: " + last.bookID + " | Available: " + last.isAvailable);
            last = last.prev;
        }
    }
}

public class BoQ {
    public static void main(String[] args) {
        Library library = new Library();

        library.inE("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.inE("1984", "George Orwell", "Dystopian", 102, true);
        library.inE("To Kill a Mockingbird", "Harper Lee", "Classic", 103, true);
        System.out.println("Library after inserting at end:");
        library.displayForward();

        library.inB("Pride and Prejudice", "Jane Austen", "Romance", 104, true);
        System.out.println("After inserting Pride and Prejudice at beginning:");
        library.displayForward();

        library.inS("Moby-Dick", "Herman Melville", "Adventure", 105, true, 3);
        System.out.println("After inserting Moby-Dick at position 3:");
        library.displayForward();

        library.search("1984", "George Orwell");
        library.search("The Catcher in the Rye", "J.D. Salinger");

        library.modifyAvailability(102, false);
        System.out.println("After modifying availability of 1984:");
        library.displayForward();

        System.out.println("Total number of books in the library: " + library.countBooks());

        library.delB();
        System.out.println("After deleting from beginning:");
        library.displayForward();

        library.delE();
        System.out.println("After deleting from end:");
        library.displayForward();

        library.delS(101);
        System.out.println("After deleting book ID 101:");
        library.displayForward();

        System.out.println("Displaying books in reverse order:");
        library.displayBackward();
    }
}

