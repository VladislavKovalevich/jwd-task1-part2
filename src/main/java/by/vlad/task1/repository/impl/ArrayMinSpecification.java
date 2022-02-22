package by.vlad.task1.repository.impl;

import by.vlad.task1.entity.CustomArray;
import by.vlad.task1.repository.Specification;
import by.vlad.task1.service.CustomArrayMath;
import by.vlad.task1.service.impl.CustomArrayMathImpl;

import java.util.OptionalInt;

public class ArrayMinSpecification implements Specification {
    private int min;

    public ArrayMinSpecification(int min) {
        this.min = min;
    }

    @Override
    public boolean specify(CustomArray item) {
        CustomArrayMath customArrayMath = new CustomArrayMathImpl();
        OptionalInt min = customArrayMath.minNumber(item);

        if (!min.isPresent()){
            return false;
        }else{
            return min.getAsInt() == this.min;
        }
    }
}
