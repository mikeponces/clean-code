package com.cleancode.classes;

import java.util.List;

import com.cleancode.methods.Item;

//class Cart {
//    double calculateTotal(List<Item> items) {
//        return 0; // some logic
//    }
//}

class Cart {
    private List<PricingRule> pricingRules;
    
    Cart(List<PricingRule> rules) {
        this.pricingRules = rules;
    }
    
    double calculateTotal(List<Item> items) {
        double total = 0; // some logic
        
        for (PricingRule rule : pricingRules) {
            total = rule.apply(total);
        }
        
        return total;
    }
}

class PremiumDiscount implements PricingRule {
    public double apply(double total) { return total * 0.9; }
}

class ExpressFee implements PricingRule {
    public double apply(double total) { return total + 10; }
}

interface PricingRule {
	double apply(double total);
}

class PremiumCart extends Cart {
    double calculateTotal(List<Item> items) {
        return super.calculateTotal(items) * 0.9; // give 10% discount
    }
}

class ExpressCart extends Cart {
    double calculateTotal(List<Item> items) {
        return super.calculateTotal(items) + 10; // add express fee
    }
}

