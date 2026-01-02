package com.shopping;

public class ElectronicsItem extends Item {
    private int warrantyMonths;

    public ElectronicsItem(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    @Override
    public String toString() {
        return "ElectronicsItem{id='" + getId() + "', name='" + getName() + "', price=" + getPrice() +
                ", warranty=" + warrantyMonths + " months}";
    }
}
