package com.indigo.nte.order;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Order {
	private int orderId;
	private String symbol;
	private double price;
	private boolean sell;
	private int quantity;

	protected Order() {
	}

	public boolean isBuy() {
		return !isSell();
	}

	public boolean isSell() {
		return sell;
	}

	public void setSell(boolean sell) {
		this.sell = sell;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
