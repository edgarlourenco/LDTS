package com.aor.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListSorter implements GenericListSorter{

    public List<Integer> sort(List<Integer> list) {
        List<Integer> sorted = new ArrayList<>();
        for (Integer number : list)
            sorted.add(number);

        for (int i = 0; i < sorted.size() - 1; i++)
            for (int j = i + 1; j < sorted.size(); j++)
                if (sorted.get(i) > sorted.get(j))
                    Collections.swap(sorted, i, j);

        return sorted;
    }
}
