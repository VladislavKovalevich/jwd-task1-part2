package by.vlad.task2.entity.comparator;

import by.vlad.task2.entity.CustomArray;

import java.util.Comparator;

public class ArrayFirstItemComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        int[] firstArray = o1.getArray();
        int[] secondArray = o2.getArray();
        return firstArray[0] - secondArray[0];
    }
}