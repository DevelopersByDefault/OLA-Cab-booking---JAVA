package com.OLA;

import java.util.ArrayList;
import java.util.InputMismatchException;
/*
 * 
 * @author Easwaran
 */
import java.util.Scanner;

public class Ola {
	static OlaAdmin olaAdmin = new OlaAdmin();
	static int n = 1;
	static int[] availabileCars = new int[6];

	public static void main(String[] args) {
		// Get input from user
		// calc();

		inputDatas(olaAdmin);

	}

	public static void inputDatas(OlaAdmin olaAdmin) {
		Scanner scan = new Scanner(System.in);

		System.out.println("*****************  OLA CABS  *********************");
		System.out.println("Customer ID : " + olaAdmin.getCustomerID());
		// Auto Increment customer ID
		// Remember to decrement if Order Fails
		try {
			olaAdmin.setCustomerID(olaAdmin.getCustomerID() + 1);
			System.out.println("");
			System.out.print("Pickup Point : ");
			olaAdmin.setPickupPoint(scan.next().toUpperCase().charAt(0));
			System.out.println("");

			System.out.print("Drop Point : ");
			olaAdmin.setDropPoint(scan.next().toUpperCase().charAt(0));
			System.out.println("");

			System.out.print("Pickup Time (24 hrs Format) : ");
			olaAdmin.setPickupTime(scan.nextInt());
			System.out.println("");

			calc();

		} catch (InputMismatchException ie) {
			System.err.println("Enter valid entry");
			System.out.println("");
			olaAdmin.setCustomerID(olaAdmin.getCustomerID() - 1);
			Ola.inputDatas(olaAdmin);

		} finally {
			scan.close();
		}
	}

	public static void calc() {
		// OlaAdmin olaAdmin = new OlaAdmin();

		int MIN_CHARGE = 100;

		if (n == 7) {
			n = 1;
		}

		// Ascii Conversion
		char x = olaAdmin.getPickupPoint();
		int startPoint = (int) x;
		char y = olaAdmin.getDropPoint();
		int endPoint = (int) y;

		// Charge calculation
		int difference = Math.abs(x - y);
		int distance = (difference * 15) - 5;
		int normalCharge = distance * 10;
		int ab = 1;
		/*for (int i : availabileCars) {
			if (olaAdmin.getPickupTime() <= i) {
				i++;
			} else {
				ab = i + 1;
			}
		}
		System.out.println(ab);*/
		// Total Fare
		int rideCharge = MIN_CHARGE + normalCharge;

		System.out.println("Taxi can be allocated");
		System.out.println("Ride Charge Estimation : " + rideCharge + " Rs/-");
		System.out.println("Taxi " + n + " is allocated.");
		n++;
		System.out.println("");

		// Taxi allocation
		int time = olaAdmin.getPickupTime() + difference;

		if (time > 24) {
			time = time - 24;
		}
		//// olaAdmin.setPickupTime(time);

		System.out.println("Free at : " + time);
		availabileCars[n] = time;
		//// System.out.println(availabileCars[n]);

		// Recurrsion
		inputDatas(olaAdmin);
	}
}