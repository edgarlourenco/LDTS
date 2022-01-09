package com.aor.refactoring.example3;

public class FixedDiscount extends Discount {

    public FixedDiscount(double fixed) {
        super(fixed);
    }

    @Override
    public double applyDiscount(double price) {
        return price - getDiscount();
    }
}
