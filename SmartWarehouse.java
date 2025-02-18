import java.util.ArrayList;
import java.util.List;
abstract class WarehouseItem {
    abstract void display();
}

class Electronics extends WarehouseItem {
    void display() {
        System.out.println("Electronics item");
    }
}

class Groceries extends WarehouseItem {
    void display() {
        System.out.println("Groceries item");
    }
}

class Furniture extends WarehouseItem {
    void display() {
        System.out.println("Furniture item");
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    
    void addItem(T item) {
        items.add(item);
    }
    
    void displayItems() {
        for (T item : items) {
            item.display();
        }
    }
    
    void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.display();
        }
    }
}

public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<WarehouseItem> warehouse = new Storage<>();
        
        warehouse.addItem(new Electronics());
        warehouse.addItem(new Groceries());
        warehouse.addItem(new Furniture());
        
        warehouse.displayItems();
        
        List<WarehouseItem> allItems = new ArrayList<>();
        allItems.add(new Electronics());
        allItems.add(new Groceries());
        allItems.add(new Furniture());
        
        warehouse.displayAllItems(allItems);
    }
}