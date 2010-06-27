package com.indigo.nte.order;

public enum MultiStockHint implements StockHint {

	IBM("IBM", 100, 140), GOOG("GOOG", 300, 700), AAPL("AAPL", 100, 300), MSFT("MSFT", 20, 28), DELL("DELL", 10, 20);

	private final String symbol;

	private final double from;

	private final double to;

	MultiStockHint(String _symbol, double _from, double _to) {
		this.symbol = _symbol;
		this.from = _from;
		this.to = _to;
	}

	/* (non-Javadoc)
	 * @see com.indiago.nte.order.Hint#getSymbol()
	 */
	public String getSymbol() {
		return symbol;
	}

	/* (non-Javadoc)
	 * @see com.indiago.nte.order.Hint#getFrom()
	 */
	public double getFrom() {
		return from;
	}

	/* (non-Javadoc)
	 * @see com.indiago.nte.order.Hint#getTo()
	 */
	public double getTo() {
		return to;
	}

}