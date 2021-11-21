package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class LitsFiltererTest {

    private List<Integer> list;

    @BeforeEach
    public void setup() {
        list = Arrays.asList(1, 2, 5, -3, 76, 0, -32, 65, -1243, 5, 8, -46);
    }

    @Test
    public void filterNotMultipleOf2() {

        DivisibleByFilter filter = new DivisibleByFilter(2);

        ListFilterer filterer = new ListFilterer(filter);

        List<Integer> expected = Arrays.asList(2, 76, 0, -32, 8, -46);

        Assertions.assertEquals(expected, filterer.filter(this.list));

    }

    @Test
    public void filterNotPositive() {

        PositiveFilter filter = new PositiveFilter();

        ListFilterer filterer = new ListFilterer(filter);

        List<Integer> expected = Arrays.asList(1, 2, 5, 76, 65, 5, 8);

        Assertions.assertEquals(expected, filterer.filter(this.list));

    }
}
