package com.indigo.nte.esper;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.indigo.nte.order.Order;

public class MightyEsper {

	private static MightyEsper instance = new MightyEsper();
	private final EPServiceProvider esperEngine;

	private MightyEsper() {
		Configuration config = new Configuration();
		config.addEventType("ClientOrder", com.indigo.nte.order.Order.class);
		esperEngine = EPServiceProviderManager.getDefaultProvider(config);
		addOrderQtyMatching();
	}

	private void addOrderQtyMatching() {
		String stmt = null;
		stmt = "select a.orderId, a.symbol, a.quantity, a.price, a.sell, b.orderId, b.symbol, b.quantity, b.price, b.sell  from ClientOrder.win:time(1800) as a, ClientOrder.win:time(1800) as b "
				+ " where a.symbol = b.symbol and " + "a.price=b.price and a.quantity = b.quantity " + "and a.sell != b.sell";
		EPStatement statement = esperEngine.getEPAdministrator().createEPL(stmt);
		statement.addListener(new UpdateListener() {

			@Override
			public void update(EventBean[] newEvents, EventBean[] arg1) {
				Map bean1 = (Map) newEvents[0].getUnderlying();
				Map bean2 = (Map) newEvents[1].getUnderlying();
				printMapBean(bean1);
				printMapBean(bean2);
			}

			private void printMapBean(Map bean) {
				Set<Map.Entry> keyValue = bean.entrySet();
				for (Entry property : keyValue) {
					System.out.printf("\t" + property.getKey() + "  :  " + property.getValue() + "\t");
				}
				System.out.println("\n");
			}
		});

	}

	public static MightyEsper getInstance() {
		return instance;
	}

	public void placeOrder(Order order) {
		esperEngine.getEPRuntime().sendEvent(order);
	}

	public void registerTradeListener() {

	}
}
