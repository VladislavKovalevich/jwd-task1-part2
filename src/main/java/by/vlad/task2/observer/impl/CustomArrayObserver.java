package by.vlad.task2.observer.impl;

import by.vlad.task2.entity.CustomArray;
import by.vlad.task2.entity.CustomArrayParameter;
import by.vlad.task2.entity.Warehouse;
import by.vlad.task2.observer.CustomArrayEvent;
import by.vlad.task2.observer.Observer;
import by.vlad.task2.service.impl.CustomArrayMathImpl;

import java.util.OptionalInt;

public class CustomArrayObserver implements Observer {
    @Override
    public void parameterChanged(CustomArrayEvent event) {
        CustomArray customArray = event.getSource();
        CustomArrayMathImpl customArrayMath = new CustomArrayMathImpl();

        OptionalInt min = customArrayMath.minNumber(customArray);
        OptionalInt max = customArrayMath.maxNumber(customArray);
        OptionalInt sum = customArrayMath.sum(customArray);

        CustomArrayParameter customArrayParameter = new CustomArrayParameter(min, max, sum);

        Integer arrayId = customArray.getId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.replace(arrayId, customArrayParameter);
    }
}