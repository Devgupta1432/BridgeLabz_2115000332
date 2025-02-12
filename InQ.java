
class Node {
    String itemName;
    int itemID;
    int quantity;
    double price;
    Node next;

    public Node(String itemName, int itemID, int quantity, double price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    Node head;

    public void inB(String itemName, int itemID, int quantity, double price) {
        Node newNode = new Node(itemName, itemID, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    public void inE(String itemName, int itemID, int quantity, double price) {
        Node newNode = new Node(itemName, itemID, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public void inS(String itemName, int itemID, int quantity, double price, int p) {
        if (p == 1) {
            inB(itemName, itemID, quantity, price);
            return;
        }
        Node newNode = new Node(itemName, itemID, quantity, price);
        Node temp = head;
        for (int i = 1; i < p - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid Position!");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void delB() {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        head = head.next;
    }

    public void delE() {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void delS(int p) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        if (p == 1) {
            delB();
            return;
        }
        Node temp = head;
        for (int i = 1; i < p - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Invalid Position!");
            return;
        }
        temp.next = temp.next.next;
    }

    public boolean search(int itemID, String itemName) {
        Node temp = head;
        while (temp != null) {
            if (temp.itemID == itemID || temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + temp.itemName + " | ID: " + temp.itemID + " | Qty: " + temp.quantity + " | Price: $" + temp.price);
                return true;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
        return false;
    }

    public void modifyQuantity(int itemID, int newQuantity) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.itemID == itemID) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID: " + itemID);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }

    public double totalValue() {
        double total = 0;
        Node temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        return total;
    }

    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.println("Item: " + curr.itemName + " | ID: " + curr.itemID + " | Qty: " + curr.quantity + " | Price: $" + curr.price);
            curr = curr.next;
        }
    }
}

public class InQ {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.inE("Laptop", 101, 5, 1200.50);
        inventory.inE("Phone", 102, 10, 800.75);
        inventory.inE("Tablet", 103, 7, 500.99);
        System.out.println("Inventory after inserting at end:");
        inventory.display();

        inventory.inB("Headphones", 104, 15, 100.25);
        System.out.println("After inserting Headphones at beginning:");
        inventory.display();

        inventory.inS("Monitor", 105, 6, 300.00, 3);
        System.out.println("After inserting Monitor at position 3:");
        inventory.display();

        inventory.search(102, "Phone");
        inventory.search(999, "Keyboard");

        inventory.modifyQuantity(103, 12);
        System.out.println("After updating quantity of Tablet:");
        inventory.display();

        System.out.println("Total Inventory Value: $" + inventory.totalValue());

        inventory.delB();
        System.out.println("After deleting from beginning:");
        inventory.display();

        inventory.delE();
        System.out.println("After deleting from end:");
        inventory.display();

        inventory.delS(2);
        System.out.println("After deleting at position 2:");
        inventory.display();
    }
}


