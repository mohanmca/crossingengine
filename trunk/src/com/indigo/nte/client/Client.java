package com.indigo.nte.client;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.indigo.nte.exchange.Exchange;
import com.indigo.nte.executor.Command;
import com.indigo.nte.executor.CommandExecutor;
import com.indigo.nte.order.Order;
import com.indigo.nte.order.OrderGenerator;

public class Client {
	
	static final Logger LOGGER = Logger.getLogger(Client.class);
	
	public static void main(String... args) {
		Command placeOrderCommand = new Command() {
			@Override
			public void execute() {
				Order ord = OrderGenerator.getInstance().getNext();
				LOGGER.debug(ord.toString());
				Exchange.getInstance().placeOrder(ord);
			}
		};
		CommandExecutor.INSTANCE.executeFor(5, TimeUnit.SECONDS, placeOrderCommand);
	}

}
