package com.shopping;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingSystem system = new ShoppingSystem();
        Scanner scanner = new Scanner(System.in);

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

        Customer customer1 = new Customer("C001", "Aibek Nurlan", "aibek@mail.com");
        Customer customer2 = new Customer("C002", "Aigerim Kanat", "aigerim@mail.com");
        Customer customer3 = new Customer("C003", "Daniyar Serik", "daniyar@mail.com");
        system.addCustomer(customer1);
        system.addCustomer(customer2);
        system.addCustomer(customer3);

        Order order1 = new Order("O001", customer1);
        order1.addItem(item3);
        order1.addItem(item5);
        system.addOrder(order1);

        Order order2 = new Order("O002", customer2);
        order2.addItem(item1);
        system.addOrder(order2);

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Show all items");
            System.out.println("2. Show all customers");
            System.out.println("3. Show all orders");
            System.out.println("4. Search items by name");
            System.out.println("5. Filter by category");
            System.out.println("6. Filter by price");
            System.out.println("7. Sort by price");
            System.out.println("8. Sort by name");
            System.out.println("0. Exit");
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
                    scanner.close();
                    return;
            }
        }
    }
}
