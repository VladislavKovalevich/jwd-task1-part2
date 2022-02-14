package by.vlad.task2.repository.impl;

import by.vlad.task2.entity.CustomArray;
import by.vlad.task2.repository.Specification;

public class ArrayLengthSpecification implements Specification {
    private int minLength;
    private int maxLength;

    public ArrayLengthSpecification(int maxLength) {
        this.maxLength = maxLength;
        this.minLength = 0;
    }

    public ArrayLengthSpecification(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean specify(CustomArray item) {
        int[] array = item.getArray();
        return (array.length >= minLength && array.length < maxLength);
    }
}
