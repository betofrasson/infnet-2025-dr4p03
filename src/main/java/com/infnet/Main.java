package com.infnet;

import com.infnet.model.Client;
import com.infnet.model.Item;
import com.infnet.model.Order;
import com.infnet.service.OrderService;

public class Main {
    public static void main(String[] args) {

        double discountRate = 0.1;

        Client client = new Client("Pedro da Silva", "pedro@silva.com");

        Order order = new Order(client, discountRate);
        order.addItem(new Item("Coca-cola", 10, 7.5));
        order.addItem(new Item("Pepsi", 2, 5.59));
        order.addItem(new Item("Fanta", 8, 4));

        OrderService orderService = new OrderService();
        orderService.printInvoice(order);
        orderService.sendEmail(order);

    }
}