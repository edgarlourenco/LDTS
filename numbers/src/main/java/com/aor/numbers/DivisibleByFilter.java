package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{

    private int divisor;

    public DivisibleByFilter(int divisor) {
        this.divisor = divisor;
    }

    @Override
    public boolean accept(Integer number) {
        if (this.divisor == 0) return false;

        return number % this.divisor == 0;
    }
}
