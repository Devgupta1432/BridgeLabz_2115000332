class TicketNode {
    int ticketID;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class CircularLinkedList {
    TicketNode head;

    public void inE(int ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
        TicketNode newNode = new TicketNode(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            return;
        }
        TicketNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    public void del(int ticketID) {
        if (head == null) {
            System.out.println("No tickets booked!");
            return;
        }
        TicketNode temp = head, prev = null;
        do {
            if (temp.ticketID == ticketID) {
                if (temp == head && temp.next == head) {
                    head = null;
                } else if (temp == head) {
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Ticket ID " + ticketID + " has been canceled.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Ticket ID " + ticketID + " not found!");
    }

    public boolean search(String customerName, String movieName) {
        if (head == null) {
            System.out.println("No tickets booked!");
            return false;
        }
        TicketNode temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName) || temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Ticket Found: ID: " + temp.ticketID + " | Customer: " + temp.customerName + " | Movie: " + temp.movieName + " | Seat: " + temp.seatNumber + " | Time: " + temp.bookingTime);
                return true;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("Ticket not found!");
        return false;
    }

    public int countTickets() {
        if (head == null) return 0;
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    public void display() {
        if (head == null) {
            System.out.println("No tickets booked!");
            return;
        }
        TicketNode temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketID + " | Customer: " + temp.customerName + " | Movie: " + temp.movieName + " | Seat: " + temp.seatNumber + " | Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }
}

public class TickQ {
    public static void main(String[] args) {
        CircularLinkedList tickets = new CircularLinkedList();

        tickets.inE(101, "Alice", "Inception", 12, "10:30 AM");
        tickets.inE(102, "Bob", "Titanic", 25, "1:00 PM");
        tickets.inE(103, "Charlie", "Avatar", 30, "3:45 PM");
        System.out.println("Tickets after booking:");
        tickets.display();

        tickets.search("Alice", "Inception");
        tickets.search("David", "Interstellar");

        System.out.println("Total tickets booked: " + tickets.countTickets());

        tickets.del(102);
        System.out.println("After canceling ticket ID 102:");
        tickets.display();

        System.out.println("Total tickets booked: " + tickets.countTickets());
    }
}

