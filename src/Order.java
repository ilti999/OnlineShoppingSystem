public class Order {
    private int orderNumber;
    private Customer customer;
    private Item item;
    private int quantity;
    private double totalPrice;

    public Order(int orderNumber, Customer customer, Item item, int quantity){
        this.orderNumber=orderNumber;
        this.customer=customer;
        this.item=item;
        this.quantity=quantity;
        this.totalPrice=item.getPrice()*quantity;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Item getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayInfo(){
        System.out.println("=== ORDER #" + orderNumber + "===");
        System.out.println("Customer: "+customer.getName());
        System.out.println("Item: " + item.getName());
        System.out.println("Quantity: "+quantity);
        System.out.println("Total Price: ₸" + totalPrice);
        System.out.println("===============");
    }
}
