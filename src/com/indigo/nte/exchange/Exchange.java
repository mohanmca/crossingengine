package com.indigo.nte.exchange;

import com.indigo.nte.esper.MightyEsper;
import com.indigo.nte.order.Order;

public class Exchange {
	private final static Exchange instance = new Exchange();
	private final MightyEsper esper = MightyEsper.getInstance();

	public static Exchange getInstance() {
		return instance;
	}

	public void placeOrder(Order order) {
		esper.placeOrder(order);
	}

}
