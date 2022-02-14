package by.vlad.task2.entity.comparator;

import by.vlad.task2.entity.CustomArray;

import java.util.Comparator;

public class ArrayLengthComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return o1.getArray().length - o2.getArray().length;
    }
}
