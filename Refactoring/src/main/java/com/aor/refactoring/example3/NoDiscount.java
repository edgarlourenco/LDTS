package com.aor.refactoring.example3;

public class NoDiscount extends Discount {

    public NoDiscount() {
        super(0);
    }

    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
