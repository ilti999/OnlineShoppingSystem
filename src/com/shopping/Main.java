package com.shopping;

import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        ShoppingSystem system = new ShoppingSystem();
        Scanner scanner = new Scanner(System.in);

        // ===== ITEMS =====
        FurnitureItem item1 = new FurnitureItem("I001", "Desk", 150000.0, "Wood");
        FurnitureItem item2 = new FurnitureItem("I002", "Chair", 95000.0, "Metal");
        ElectronicsItem item3 = new ElectronicsItem("I003", "Laptop", 850000.0, 24);
        ElectronicsItem item4 = new ElectronicsItem("I004", "Phone", 550000.0, 12);
        Item item5 = new Item("I005", "Notebook", 5000.0);

        system.addItem(item1);
        system.addItem(item2);
        system.addItem(item3);
        system.addItem(item4);
        system.addItem(item5);

        // ===== CUSTOMERS (in-memory) =====
        Customer customer1 = new Customer("C001", "Aibek Nurlan", "aibek@mail.com");
        Customer customer2 = new Customer("C002", "Aigerim Kanat", "aigerim@mail.com");
        Customer customer3 = new Customer("C003", "Daniyar Serik", "daniyar@mail.com");
        Customer customer4 = new Customer("C004", "Kto to", "ktoto@mail.com");

        system.addCustomer(customer1);
        system.addCustomer(customer2);
        system.addCustomer(customer3);
        system.addCustomer(customer4);

        // ===== ORDERS (in-memory) =====
        Order order1 = new Order("O001", customer1);
        order1.addItem(item3);   // Laptop
        order1.addItem(item5);   // Notebook
        system.addOrder(order1);

        Order order2 = new Order("O002", customer2);
        order2.addItem(item1);   // Desk
        system.addOrder(order2);

        // ===== MAIN LOOP: choose mode =====
        CustomerDAO customerDAO = new CustomerDAO();

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. User menu");
            System.out.println("2. Admin menu");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int mode = scanner.nextInt();
            scanner.nextLine();

            if (mode == 0) {
                System.out.println("Bye!");
                break;
            }

            switch (mode) {
                case 1:
                    runUserMenu(system, scanner);
                    break;
                case 2:
                    runAdminMenu(customerDAO, scanner);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }

        scanner.close();
    }

    // ================= USER MENU =================
    private static void runUserMenu(ShoppingSystem system, Scanner scanner) {
        while (true) {
            System.out.println("\n=== USER MENU ===");
            System.out.println("1. Show all items");
            System.out.println("2. Show all customers");
            System.out.println("3. Show all orders");
            System.out.println("4. Search items by name");
            System.out.println("5. Filter by category");
            System.out.println("6. Filter by price");
            System.out.println("7. Sort by price");
            System.out.println("8. Sort by name");
            System.out.println("0. Back to main menu");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    system.displayAllItems();
                    break;
                case 2:
                    system.displayAllCustomers();
                    break;
                case 3:
                    system.displayAllOrders();
                    break;
                case 4:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    List<Item> found = system.searchByName(name);
                    for (Item item : found) {
                        System.out.println(item);
                    }
                    break;
                case 5:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    List<Item> filtered = system.filterByCategory(category);
                    for (Item item : filtered) {
                        System.out.println(item);
                    }
                    break;
                case 6:
                    System.out.print("Min price: ");
                    double min = scanner.nextDouble();
                    System.out.print("Max price: ");
                    double max = scanner.nextDouble();
                    List<Item> priceFiltered = system.filterByPrice(min, max);
                    for (Item item : priceFiltered) {
                        System.out.println(item);
                    }
                    break;
                case 7:
                    List<Item> sortedPrice = system.sortByPrice();
                    for (Item item : sortedPrice) {
                        System.out.println(item);
                    }
                    break;
                case 8:
                    List<Item> sortedName = system.sortByName();
                    for (Item item : sortedName) {
                        System.out.println(item);
                    }
                    break;
                case 0:
                    return; // back to main menu
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    // ================= ADMIN MENU (CRUD + DB) =================
    private static void runAdminMenu(CustomerDAO customerDAO, Scanner scanner) {
        while (true) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. Create customer");
            System.out.println("2. Read all customers");
            System.out.println("3. Update customer email");
            System.out.println("4. Delete customer");
            System.out.println("0. Back to main menu");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1: // CREATE
                        System.out.print("ID (e.g. C005): ");
                        String id = scanner.nextLine();
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        Customer c = new Customer(id, name, email);
                        customerDAO.addCustomer(c);
                        System.out.println("Created.");
                        break;

                    case 2: // READ
                        List<Customer> customers = customerDAO.getAllCustomers();
                        System.out.println("\n=== Customers from DB ===");
                        for (Customer cust : customers) {
                            System.out.println(cust);
                        }
                        break;

                    case 3: // UPDATE
                        System.out.print("Enter customer id (e.g. C001): ");
                        String updId = scanner.nextLine();
                        System.out.print("New email: ");
                        String newEmail = scanner.nextLine();
                        customerDAO.updateCustomerEmail(updId, newEmail);
                        System.out.println("Updated.");
                        break;

                    case 4: // DELETE
                        System.out.print("Enter customer id (e.g. C001): ");
                        String delId = scanner.nextLine();
                        customerDAO.deleteCustomer(delId);
                        System.out.println("Deleted.");
                        break;

                    case 0:
                        return; // back to main menu

                    default:
                        System.out.println("Wrong choice");
                }
            } catch (SQLException e) {
                System.out.println("DB error: " + e.getMessage());
            }
        }
    }
}
