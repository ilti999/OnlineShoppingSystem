package com.shopping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShoppingSystem {
    private List<Item> items;
    private List<Customer> customers;
    private List<Order> orders;

    public ShoppingSystem() {
        this.items = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Item> searchByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    public List<Item> filterByCategory(String category) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getCategory().equals(category)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<Item> filterByPrice(double minPrice, double maxPrice) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getPrice() >= minPrice && item.getPrice() <= maxPrice) {
                result.add(item);
            }
        }
        return result;
    }

    public List<Item> sortByPrice() {
        List<Item> sorted = new ArrayList<>(items);
        sorted.sort(Comparator.comparingDouble(Item::getPrice));
        return sorted;
    }

    public List<Item> sortByName() {
        List<Item> sorted = new ArrayList<>(items);
        sorted.sort(Comparator.comparing(Item::getName));
        return sorted;
    }

    public void displayAllItems() {
        System.out.println("\n=== All Items ===");
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void displayAllCustomers() {
        System.out.println("\n=== All Customers ===");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void displayAllOrders() {
        System.out.println("\n=== All Orders ===");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
