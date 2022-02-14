package by.vlad.task2.creator.impl;

import by.vlad.task2.creator.Creator;
import by.vlad.task2.entity.CustomArray;

import java.util.List;

public class CreatorImpl implements Creator {

    @Override
    public CustomArray createArrayFromList(List<Integer> integerList) {
        return new CustomArray(integerList);
    }
}
