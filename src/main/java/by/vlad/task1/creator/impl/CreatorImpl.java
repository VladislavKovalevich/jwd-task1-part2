package by.vlad.task1.creator.impl;

import by.vlad.task1.creator.Creator;
import by.vlad.task1.entity.CustomArray;

import java.util.List;

public class CreatorImpl implements Creator {

    @Override
    public CustomArray createArrayFromList(List<Integer> integerList) {
        return new CustomArray(integerList);
    }
}
