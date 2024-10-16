import java.util.ArrayList;
import java.util.Scanner;

class GroceryItem {
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public GroceryItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayItem() {
        System.out.printf("Item: %s, Price: $%.2f, Quantity: %d%n", name, price, quantity);
    }
}

class InventoryManagementSystem {
    private static ArrayList<GroceryItem> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Method to add a new item
    public static void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        GroceryItem newItem = new GroceryItem(name, price, quantity);
        inventory.add(newItem);
        System.out.println("Item added successfully.");
    }

    // Method to update an item's quantity
    public static void updateItem() {
        System.out.print("Enter item name to update: ");
        String name = scanner.nextLine();
        for (GroceryItem item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new quantity: ");
                int newQuantity = scanner.nextInt();
                item.setQuantity(newQuantity);
                System.out.println("Item updated successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    // Method to delete an item
    public static void deleteItem() {
        System.out.print("Enter item name to delete: ");
        String name = scanner.nextLine();
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(name)) {
                inventory.remove(i);
                System.out.println("Item deleted successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    // Method to view the inventory
    public static void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("The inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            for (GroceryItem item : inventory) {
                item.displayItem();
            }
        }
    }

    // Method to search for an item
    public static void searchItem() {
        System.out.print("Enter item name to search: ");
        String name = scanner.nextLine();
        for (GroceryItem item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.displayItem();
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nGrocery Inventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item Quantity");
            System.out.println("3. Delete Item");
            System.out.println("4. View Inventory");
            System.out.println("5. Search Item");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    updateItem();
                    break;
                case 3:
                    deleteItem();
                    break;
                case 4:
                    viewInventory();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }
}
