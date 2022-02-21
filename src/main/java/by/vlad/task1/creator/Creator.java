package by.vlad.task1.creator;

import by.vlad.task1.entity.CustomArray;

import java.util.List;

public interface Creator {
    CustomArray createArrayFromList(List<Integer> integerList);
}
