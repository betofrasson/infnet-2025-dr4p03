package com.infnet.service;

import com.infnet.model.Item;
import com.infnet.model.Order;
import com.infnet.util.DiscountPolicy;

import java.text.DecimalFormat;

public class OrderService {

    public void printInvoice(Order order) {
        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println("Cliente: " + order.getClient().getName());

        System.out.println("============== ITENS ==============");
        for (Item item : order.getItems()) {
            System.out.println("Produto: " + item.getName());
            System.out.println("Qtde: " + item.getQuantity());
            System.out.println("Valor Unit: R$ " + df.format(item.getPrice()));
            System.out.println("Valor Total: R$ " + df.format(item.getTotalPrice()));
            System.out.println("");
        }

        double subtotal = order.calculateSubtotal();
        double discount = DiscountPolicy.calculateDiscount(subtotal, order.getDiscountRate());
        double total = subtotal - discount;

        System.out.println("===================================");
        System.out.println("Subtotal: R$ " + df.format(subtotal));
        System.out.println("Desconto: R$ " + df.format(discount));
        System.out.println("Total final: R$ " + df.format(total));
        System.out.println("===================================");
    }

    public void sendEmail(Order order) {
        EmailService.sendEmail(order.getClient().getEmail(), "Pedido recebido! Obrigado pela compra.");
    }
}
