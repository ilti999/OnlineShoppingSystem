public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("iPhone 15 Pro", 1200000.0, 10);
        Item item2 = new Item("Samsung Galaxy", 900000.0, 15);
        Item item3 = new Item("MacBook Air", 1500000.0, 5);

        Customer customer1 = new Customer("Alina", "alina@gmail.com", "+770112345678");
        Customer customer2 = new Customer("Assem", "assem@gmail.com", "+770787654321");

        Order order1 = new Order(1, customer1, item1, 2);
        Order order2 = new Order(2, customer2, item2, 1);
        Order order3 = new Order(3, customer1, item3, 1);

        System.out.println("=== ITEMS ===");
        item1.displayInfo();
        item2.displayInfo();
        item3.displayInfo();

        System.out.println("\n=== CUSTOMERS ===");
        customer1.displayInfo();
        customer2.displayInfo();

        System.out.println("\n=== ORDERS ===");
        order1.displayInfo();
        order2.displayInfo();
        order3.displayInfo();

        System.out.println("\n===ITEM COMPARISON===");
        if (item1.getPrice() > item2.getPrice()) {
            System.out.println(item1.getName() + " is more expensive than " + item2.getName());
        } else {
            System.out.println(item2.getName() + " is more expensive than" + item1.getName());
        }

        System.out.println("\n=== ORDER COMPARISON ===");
        if (order1.getTotalPrice() > order2.getTotalPrice()) {
            System.out.println("Order #" + order1.getOrderNumber() + " is more expensive (₸" + order1.getTotalPrice() + ")");
        } else {
            System.out.println("Order #" + order2.getOrderNumber() + " is more expensive (₸" + order1.getTotalPrice() + ")");
        }
    }
}