package Java_collections_worksheet_1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

class Order {
    private int orderId;
    private String itemName;
    private int quantity;
    private String status;

    public Order(int orderId, String itemName, int quantity) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.status = "Pending";
    }

    public int getOrderId() {
        return orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Item: " + itemName + ", Quantity: " + quantity + ", Status: " + status;
    }
}

public class Q14_Restaurant_Order_System {
    private Deque<Order> currentOrders;
    private List<Order> orderHistory;
    private int orderIdCounter;

    public Q14_Restaurant_Order_System() {
        currentOrders = new ArrayDeque<>();
        orderHistory = new ArrayList<>();
        orderIdCounter = 1;
    }

    public void addOrderToFront(String itemName, int quantity) {
        Order order = new Order(orderIdCounter++, itemName, quantity);
        currentOrders.addFirst(order);
        orderHistory.add(order);
        System.out.println("Order added to front: " + order);
    }

    public void addOrderToBack(String itemName, int quantity) {
        Order order = new Order(orderIdCounter++, itemName, quantity);
        currentOrders.addLast(order);
        orderHistory.add(order);
        System.out.println("Order added to back: " + order);
    }

    public void removeOrderFromFront() {
        if (!currentOrders.isEmpty()) {
            Order order = currentOrders.removeFirst();
            order.setStatus("Completed");
            System.out.println("Order removed from front: " + order);
        } else {
            System.out.println("No orders to remove from front.");
        }
    }

    public void removeOrderFromBack() {
        if (!currentOrders.isEmpty()) {
            Order order = currentOrders.removeLast();
            order.setStatus("Completed");
            System.out.println("Order removed from back: " + order);
        } else {
            System.out.println("No orders to remove from back.");
        }
    }

    public void displayCurrentOrders() {
        if (currentOrders.isEmpty()) {
            System.out.println("No current orders.");
        } else {
            System.out.println("Current Orders:");
            for (Order order : currentOrders) {
                System.out.println(order);
            }
        }
    }

    public void displayOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("No order history.");
        } else {
            System.out.println("Order History:");
            for (Order order : orderHistory) {
                System.out.println(order);
            }
        }
    }

    public static void main(String[] args) {
        Q14_Restaurant_Order_System system = new Q14_Restaurant_Order_System();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Order to Front");
            System.out.println("2. Add Order to Back");
            System.out.println("3. Remove Order from Front");
            System.out.println("4. Remove Order from Back");
            System.out.println("5. Display Current Orders");
            System.out.println("6. Display Order History");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemNameFront = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantityFront = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    system.addOrderToFront(itemNameFront, quantityFront);
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    String itemNameBack = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantityBack = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    system.addOrderToBack(itemNameBack, quantityBack);
                    break;
                case 3:
                    system.removeOrderFromFront();
                    break;
                case 4:
                    system.removeOrderFromBack();
                    break;
                case 5:
                    system.displayCurrentOrders();
                    break;
                case 6:
                    system.displayOrderHistory();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
