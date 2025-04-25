package Java_oops_Worksheet_1;

import java.util.ArrayList;
import java.util.Scanner;

// Item class
class InventoryItem {
    private int id;
    private String name;
    private double price;

    public InventoryItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "InventoryItem [ID=" + id + ", Name=" + name + ", Price=" + price + "]";
    }
}

// Store class
class Store {
    private ArrayList<InventoryItem> inventoryItems;

    public Store() {
        inventoryItems = new ArrayList<>();
    }

    public void addItem(InventoryItem item) {
        inventoryItems.add(item);
    }

    public void displayAllItems() {
        for (InventoryItem item : inventoryItems) {
            System.out.println(item);
        }
    }

    public InventoryItem findItemWithHighestPrice() {
        if (inventoryItems.isEmpty()) {
            return null;
        }

        InventoryItem highestPricedItem = inventoryItems.get(0);
        for (InventoryItem item : inventoryItems) {
            if (item.getPrice() > highestPricedItem.getPrice()) {
                highestPricedItem = item;
            }
        }
        return highestPricedItem;
    }

    public InventoryItem searchItemByName(String name) {
        for (InventoryItem item : inventoryItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}

// Main class to test the functionality
public class Q10_Inventory_System {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Store store = new Store();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Item");
            System.out.println("2. Display All Items");
            System.out.println("3. Find Item with Highest Price");
            System.out.println("4. Search Item by Name");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addItem(store);
                    break;
                case 2:
                    store.displayAllItems();
                    break;
                case 3:
                    InventoryItem highestPricedItem = store.findItemWithHighestPrice();
                    if (highestPricedItem != null) {
                        System.out.println("Item with Highest Price: " + highestPricedItem);
                    } else {
                        System.out.println("No items in the store.");
                    }
                    break;
                case 4:
                    searchItemByName(store);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addItem(Store store) {
        System.out.print("Enter item ID: ");
        int id = scanner.nextInt();

        scanner.nextLine(); // Consume newline

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();

        InventoryItem item = new InventoryItem(id, name, price);
        store.addItem(item);

        System.out.println("Item added successfully.");
    }

    private static void searchItemByName(Store store) {
        System.out.print("Enter item name to search: ");
        String name = scanner.nextLine();

        InventoryItem item = store.searchItemByName(name);

        if (item != null) {
            System.out.println("Item found: " + item);
        } else {
            System.out.println("No item found with the name '" + name + "'.");
        }
    }
}
