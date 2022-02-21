package by.vlad.task1.repository.impl;

import by.vlad.task1.entity.CustomArray;
import by.vlad.task1.repository.Specification;
import by.vlad.task1.service.CustomArrayMath;
import by.vlad.task1.service.impl.CustomArrayMathImpl;

import java.util.OptionalInt;

public class ArrayMaxSpecification implements Specification {
    private int max;

    public ArrayMaxSpecification(int max) {
        this.max = max;
    }

    @Override
    public boolean specify(CustomArray item) {
        CustomArrayMath customArrayMath = new CustomArrayMathImpl();
        OptionalInt max = customArrayMath.maxNumber(item);

        if (!max.isPresent()){
            return false;
        }else{
            return max.getAsInt() < this.max;
        }
    }
}
