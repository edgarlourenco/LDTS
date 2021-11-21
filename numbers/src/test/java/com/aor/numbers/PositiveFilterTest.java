package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {

    @Test
    public void pos() {

        PositiveFilter filter = new PositiveFilter();

        Assertions.assertTrue(filter.accept(4));

    }

    @Test
    public void neg() {

        PositiveFilter filter = new PositiveFilter();

        Assertions.assertFalse(filter.accept(-4));

    }

    @Test
    public void zero() {

        PositiveFilter filter = new PositiveFilter();

        Assertions.assertFalse(filter.accept(0));

    }
}
