package com.shopping;

public class FurnitureItem extends Item {
    private String material;

    public FurnitureItem(String id, String name, double price, String material) {
        super(id, name, price);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String getCategory() {
        return "Furniture";
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.2;
    }

    @Override
    public String toString() {
        return "FurnitureItem{id='" + getId() + "', name='" + getName() + "', price=" + getPrice() +
                ", material='" + material + "'}";
    }
}
