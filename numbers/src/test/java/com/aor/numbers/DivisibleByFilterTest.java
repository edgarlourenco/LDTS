package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {

    @Test
    public void divisibleByZero() {
        DivisibleByFilter filter = new DivisibleByFilter(0);

        Assertions.assertFalse(filter.accept(0));
        Assertions.assertFalse(filter.accept(-1));
        Assertions.assertFalse(filter.accept(5));

    }

    @Test
    public void even() {
        DivisibleByFilter filter = new DivisibleByFilter(2);

        Assertions.assertTrue(filter.accept(0));
        Assertions.assertFalse(filter.accept(-1));
        Assertions.assertFalse(filter.accept(5));
        Assertions.assertTrue(filter.accept(2345670));
        Assertions.assertTrue(filter.accept(2));

    }

    @Test
    public void strangeDivisor() {
        DivisibleByFilter filter = new DivisibleByFilter(13);

        Assertions.assertTrue(filter.accept(0));
        Assertions.assertFalse(filter.accept(-1));
        Assertions.assertFalse(filter.accept(5));
        Assertions.assertTrue(filter.accept(13));
        Assertions.assertTrue(filter.accept(13*43));

    }

}
