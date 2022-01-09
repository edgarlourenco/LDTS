package com.aor.refactoring.example3;

public class SimpleOrder {
    private Discount discount;
    private double price;

    public SimpleOrder(double price) {
        this.price = price;
        this.discount = new NoDiscount();
    }

    public void setDiscount(Discount discount) {
        if (discount == null) {
            this.discount = new NoDiscount();
        } else {
            this.discount = discount;
        }
    }

    public double getTotal() {
        return discount.applyDiscount(price);
    }
}
