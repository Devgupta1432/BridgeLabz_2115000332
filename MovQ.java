
class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    MovieNode head;

    public void inB(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    public void inE(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = newNode;
            return;
        }
        MovieNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
    }

    public void inS(String title, String director, int year, double rating, int p) {
        if (p == 1) {
            inB(title, director, year, rating);
            return;
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
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
            System.out.println("List is empty!");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    public void delE() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        MovieNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    public void delS(String title) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.title.equalsIgnoreCase(title)) {
            delB();
            return;
        }
        MovieNode temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie not found!");
            return;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    public boolean search(String director, double rating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director) || temp.rating == rating) {
                System.out.println("Movie Found: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
                return true;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found!");
        return false;
    }

    public void modify(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for movie: " + title + " to " + newRating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found!");
    }

    public void displayForward() {
        MovieNode curr = head;
        while (curr != null) {
            System.out.println("Movie: " + curr.title + " | Director: " + curr.director + " | Year: " + curr.year + " | Rating: " + curr.rating);
            curr = curr.next;
        }
    }

    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        MovieNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        while (last != null) {
            System.out.println("Movie: " + last.title + " | Director: " + last.director + " | Year: " + last.year + " | Rating: " + last.rating);
            last = last.prev;
        }
    }
}

public class MovQ {
    public static void main(String[] args) {
        MovieList movies = new MovieList();

        movies.inE("Inception", "Christopher Nolan", 2010, 8.8);
        movies.inE("Titanic", "James Cameron", 1997, 7.8);
        movies.inE("Avatar", "James Cameron", 2009, 7.9);
        System.out.println("Movie List after inserting at end:");
        movies.displayForward();

        movies.inB("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        System.out.println("After inserting The Godfather at beginning:");
        movies.displayForward();

        movies.inS("Interstellar", "Christopher Nolan", 2014, 8.6, 3);
        System.out.println("After inserting Interstellar at position 3:");
        movies.displayForward();

        movies.search("James Cameron", 7.9);
        movies.search("Steven Spielberg", 9.0);

        movies.modify("Titanic", 8.2);
        System.out.println("After modifying Titanic's rating:");
        movies.displayForward();

        movies.delB();
        System.out.println("After deleting from beginning:");
        movies.displayForward();

        movies.delE();
        System.out.println("After deleting from end:");
        movies.displayForward();

        movies.delS("Inception");
        System.out.println("After deleting movie Inception:");
        movies.displayForward();

        System.out.println("Displaying movies in reverse order:");
        movies.displayBackward();
    }
}


