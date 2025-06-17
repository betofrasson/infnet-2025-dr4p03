package com.infnet.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final Client client;
    private final List<Item> items = new ArrayList<>();
    private final double discountRate;

    public Order(Client client, double discountRate) {
        this.client = client;
        this.discountRate = discountRate;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Client getClient() {
        return client;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public double calculateSubtotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}
