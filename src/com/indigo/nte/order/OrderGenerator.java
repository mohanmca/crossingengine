package com.indigo.nte.order;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

public class OrderGenerator {
	private Random random;
	AtomicInteger counter = new AtomicInteger();
	private static OrderGenerator instance = new OrderGenerator();
	
	private static final Logger LOGGER = Logger.getLogger(OrderGenerator.class);
	

	OrderGenerator() {
		random = new Random();
	}

	public static OrderGenerator getInstance() {
		return instance;
	}

	public Order getNext() {
		StockHint hint = MultiStockHint.values()[random.nextInt(MultiStockHint.values().length)];
		Order ord = new Order();
		ord.setSell(random.nextBoolean());
		ord.setSymbol(hint.getSymbol());
		ord.setPrice(Math.floor(getPrice(hint)) );
		ord.setQuantity(random.nextInt(25)+1);
		ord.setOrderId(counter.incrementAndGet());
		return ord;
	}

	private double getPrice(StockHint hint) {
		double price = 0.0;
		while (true) {
			price = random.nextDouble() * hint.getTo();
			if (price >= hint.getFrom()) {
				break;
			}
		}
		return price;
	}

	public static void main(String... args) {
		OrderGenerator ordgen = OrderGenerator.getInstance();
		for (int i = 0; i < 50; i++) {
			LOGGER.debug(ordgen.getNext().toString());
		}
	}
}
