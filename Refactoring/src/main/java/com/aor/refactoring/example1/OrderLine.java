package com.aor.refactoring.example1;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }

    public String getLineString() {
        return product.getName() + "(x" + quantity + "): " + getTotal() + "\n";
    }

}
