package com.ccsp.utils;

/**
 * @author rbongurala
 *
 */
public enum CCSPConstant {

	TOTALDEDUCTABLEAMOUNT(1200);

	private double amount;

	CCSPConstant(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
