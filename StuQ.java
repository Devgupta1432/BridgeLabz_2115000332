
class Node {
    int rollNo;
    String name;
    int age;
    char grade;
    Node next;

    public Node(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    Node head;

    public void inB(int rollNo, String name, int age, char grade) {
        Node newNode = new Node(rollNo, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    public void inE(int rollNo, String name, int age, char grade) {
        Node newNode = new Node(rollNo, name, age, grade);
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

    public void inS(int rollNo, String name, int age, char grade, int p) {
        if (p == 1) {
            inB(rollNo, name, age, grade);
            return;
        }
        Node newNode = new Node(rollNo, name, age, grade);
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

    public void del(int rollNo) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }
        Node temp = head, prev = null;
        while (temp != null && temp.rollNo != rollNo) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Student not found!");
            return;
        }
        prev.next = temp.next;
    }

    public boolean search(int rollNo) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student Found: Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return true;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll No " + rollNo + " not found.");
        return false;
    }

    public void modifyGrade(int rollNo, char newGrade) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated for Roll No: " + rollNo + " to " + newGrade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll No " + rollNo + " not found.");
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void StuQ(String[] args) {
        StudentList list = new StudentList();

        list.inE(101, "Alice", 20, 'A');
        list.inE(102, "Bob", 21, 'B');
        list.inE(103, "Charlie", 22, 'C');
        System.out.println("Student List after inserting at end:");
        list.display();

        list.inB(100, "David", 19, 'A');
        System.out.println("After inserting David at beginning:");
        list.display();

        list.inS(105, "Eve", 21, 'B', 3);
        System.out.println("After inserting Eve at position 3:");
        list.display();

        list.search(102);
        list.search(999);

        list.modifyGrade(103, 'A');
        System.out.println("After modifying Charlie's grade:");
        list.display();

        list.del(100);
        System.out.println("After deleting student with Roll No 100:");
        list.display();
    }
}

