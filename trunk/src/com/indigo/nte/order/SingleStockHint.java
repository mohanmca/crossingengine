package com.indigo.nte.order;

public enum SingleStockHint  implements StockHint {

	IBM("IBM", 100, 120);

	private final String symbol;

	private final double from;

	private final double to;

	SingleStockHint(String _symbol, double _from, double _to) {
		this.symbol = _symbol;
		this.from = _from;
		this.to = _to;
	}

	public String getSymbol() {
		return symbol;
	}

	public double getFrom() {
		return from;
	}

	public double getTo() {
		return to;
	}
	
 
}