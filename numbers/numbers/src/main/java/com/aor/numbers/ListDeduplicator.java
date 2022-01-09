package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;


public class ListDeduplicator implements GenericListDeduplicator{

    private GenericListSorter listSorter;

    public ListDeduplicator(GenericListSorter sorter) {
        this.listSorter = sorter;
    }

    public List<Integer> deduplicate(List<Integer> list) {
        List<Integer> sorted = listSorter.sort(list);
        List<Integer> unique = new ArrayList<>();

        Integer last = null;

        for (Integer number : sorted)
            if (!number.equals(last)) {
                last = number;
                unique.add(number);
            }

        return unique;
    }
}
