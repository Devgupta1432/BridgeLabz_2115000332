
class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    
    public void performDuties() {
        System.out.println(name + " is cooking meals with specialty in " + specialty + ".");
    }

    
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialty: " + specialty);
    }
}

class Waiter extends Person implements Worker {
    private String section;

    public Waiter(String name, int id, String section) {
        super(name, id);
        this.section = section;
    }

    
    public void performDuties() {
        System.out.println(name + " is serving customers in section " + section + ".");
    }

    
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Section: " + section);
    }
}

public class ChefQ {
    public static void main(String[] args) {

        Chef chef = new Chef("Gordon Ramsay", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("John Doe", 102, "North Side");

        System.out.println("Chef Info:");
        chef.displayInfo();
        chef.performDuties();
        System.out.println();

        System.out.println("Waiter Info:");
        waiter.displayInfo();
        waiter.performDuties();
    }
}
