package by.vlad.task1.entity.comparator;

import by.vlad.task1.entity.CustomArray;

import java.util.Comparator;

public class ArrayFirstItemComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        int[] firstArray = o1.getArray();
        int[] secondArray = o2.getArray();

        if (firstArray.length == 0 && secondArray.length == 0){
            return 0;
        }else{
            if (firstArray.length == 0){
                return -1;
            }else{
                if (secondArray.length == 0){
                    return 1;
                }
            }
        }

        return firstArray[0] - secondArray[0];
    }
}