package by.vlad.task1.repository.impl;

import by.vlad.task1.entity.CustomArray;
import by.vlad.task1.repository.Specification;
import by.vlad.task1.service.CustomArrayMath;
import by.vlad.task1.service.impl.CustomArrayMathImpl;

import java.util.OptionalInt;

public class ArraySumSpecification implements Specification {
    private int sum;

    public ArraySumSpecification(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean specify(CustomArray item) {
        CustomArrayMath customArrayMath = new CustomArrayMathImpl();
        OptionalInt sum = customArrayMath.sum(item);

        if (!sum.isPresent()){
            return false;
        }else{
            return sum.getAsInt() < this.sum;
        }
    }
}
