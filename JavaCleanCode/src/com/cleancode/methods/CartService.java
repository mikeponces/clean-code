package com.cleancode.methods;

import java.util.List;

public class CartService {
	
	private DiscountHandler discountHandler;
	private DeliveryHandler deliveryHandler;

	public double calculateTotal(Order order, Customer customer) {
		double baseTotal = sumItemPrices(order.getItems());
		baseTotal = discountHandler.applyVoucher(order.getVoucher(), baseTotal);
		baseTotal = deliveryHandler.addDeliveryFee(customer, baseTotal);
		return baseTotal;
	}

	private double sumItemPrices(List<Item> items) {
		// TODO Auto-generated method stub
		return 0;
	}
}

