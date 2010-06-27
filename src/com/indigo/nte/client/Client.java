package com.indigo.nte.client;

import com.indigo.nte.exchange.Exchange;
import com.indigo.nte.order.Order;
import com.indigo.nte.order.OrderGenerator;

public class Client {
	public static void main(String... args) {
		OrderGenerator generator = OrderGenerator.getInstance();
		Exchange exchange = Exchange.getInstance();
		while (true) {
			Order ord = generator.getNext();
			System.out.println(ord.toString());
			exchange.placeOrder(ord);
		}
	}
}
