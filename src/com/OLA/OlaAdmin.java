package com.OLA;

public class OlaAdmin {
	private long customerID = 1;

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public char getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(char pickupPoint) {
		this.pickupPoint = pickupPoint;
	}

	public char getDropPoint() {
		return dropPoint;
	}

	public void setDropPoint(char dropPoint) {
		this.dropPoint = dropPoint;
	}

	public int getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(int pickupTime) {
		this.pickupTime = pickupTime;
	}

	private char pickupPoint;
	private char dropPoint;
	private int pickupTime = 0;

}
