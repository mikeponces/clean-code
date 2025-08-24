package com.cleancode.methods;

import java.util.List;

public class CartService {

	private DiscountHandler discountHandler;
	private DeliveryHandler deliveryHandler;
	private EmailService emailService;

//	public double calculateTotal(Order order, Customer customer) {
//		double baseTotal = sumItemPrices(order.getItems());
//		baseTotal = discountHandler.applyVoucher(order.getVoucher(), baseTotal);
//		baseTotal = deliveryHandler.addDeliveryFee(customer, baseTotal);
//		return baseTotal;
//	}

	// 1. too many parameters
	public String calculateTotal(List<Item> items, String voucher, String address, String emailAddress,
			boolean sendEmail, int priorityThreshold, double deliveryRate) {

		double total = sumItemPrices(items);
		total = applyVoucherDiscount(voucher, total);
		total = addDeliveryFee(address, total, deliveryRate);

		// 2. side-effect: email sending based on parameter
		if (sendEmail && emailAddress != null) {
			emailService.sendOrderConfirmation(emailAddress, total);
		}

		// 3. magic return values (string or number)
		if (total > priorityThreshold) {
			return "PRIORITY";
		} else if (total < 0) {
			return "ERROR";
		}
		return String.valueOf(total);
	}

	public double calculateTotal(Order order, Customer customer) {
		double total = sumItemPrices(order.getItems());
		total = applyVoucherDiscount(order.getVoucher(), total);
		total = addDeliveryFee(customer, total);
		return total;
	}

	public OrderPriority determineOrderPriority(double total, int priorityThreshold) {
		if (total > priorityThreshold) {
			return OrderPriority.PRIORITY;
		}
		return OrderPriority.STANDARD;
	}

	public void sendOrderConfirmation(Order order) {
		emailService.sendOrderConfirmation(order);
	}

	private double addDeliveryFee(Customer customer, double total) {
		// TODO Auto-generated method stub
		return 0;
	}

	private double addDeliveryFee(String address, double total, double deliveryRate) {
		// TODO Auto-generated method stub
		return 0;
	}

	private double applyVoucherDiscount(String voucher, double total) {
		// TODO Auto-generated method stub
		return 0;
	}

	private double sumItemPrices(List<Item> items) {
		// TODO Auto-generated method stub
		return 0;
	}

//	public double calculateShippingCosts(Order order) {
//		double shippingCosts = 0; // assigned here
//
//		if (order != null) {
//			if (order.getTotalPrice() > 100) {
//				shippingCosts = 0; // assigned again
//			} else {
//				if (order.getCountry().equals("PH")) {
//					shippingCosts = 10;
//				} else {
//					shippingCosts = 20;
//				}
//			}
//		}
//
//		return shippingCosts;
//	}

	public double calculateShippingCosts(Order order) {
		if (order == null) {
			throw new IllegalArgumentException("Order cannot be null");
		}

		if (order.getTotalPrice() > 100) {
			return 0;
		}

		if (order.getCountry().equals("PH")) {
			return 10;
		}
		
		return 20;
	}
}
