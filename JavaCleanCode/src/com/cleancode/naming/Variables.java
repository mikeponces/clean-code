package com.cleancode.naming;

import java.util.List;

import com.cleancode.methods.Item;

public class Variables {

	
	public double calcTotal(List<Item> items, double d) { 
		// 1. abbreviations/shortened names 
		double tx = 0.085; 

		// 2. single-letter variables
		double t = items.stream().mapToDouble(i -> i.getPrice() * i.getQty()).sum();

		// 3. number-series when you can't think of names
		double a1 = t * tx; 
		double a2 = t + a1;
		double a3 = a2 - d;

		return a3 > 0 ? a3 : 0;
	}
	
	public double calculateDiscountedTotal(List<Item> items, final double discount) { 
		final double tax = 0.085;

		double costOfItems = items.stream().mapToDouble(item -> item.getPrice() * item.getQty()).sum();

		double taxCharge = costOfItems * tax;
		double totalCost = costOfItems + taxCharge;
		double discountedTotal = totalCost - discount;

		return discountedTotal > 0 ? discountedTotal : 0;
	}
}

