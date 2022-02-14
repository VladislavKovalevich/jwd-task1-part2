package by.vlad.task2.creator;

import by.vlad.task2.entity.CustomArray;

import java.util.List;

public interface Creator {
    CustomArray createArrayFromList(List<Integer> integerList);
}
