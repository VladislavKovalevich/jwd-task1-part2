package by.vlad.task1.observer.impl;

import by.vlad.task1.entity.CustomArray;
import by.vlad.task1.entity.CustomArrayStatistic;
import by.vlad.task1.entity.Warehouse;
import by.vlad.task1.observer.CustomArrayEvent;
import by.vlad.task1.observer.CustomArrayObserver;
import by.vlad.task1.service.impl.CustomArrayMathImpl;

import java.util.OptionalInt;

public class CustomArrayObserverImpl implements CustomArrayObserver {
    @Override
    public void parameterChanged(CustomArrayEvent event) {
        CustomArray customArray = event.getSource();
        CustomArrayMathImpl customArrayMath = new CustomArrayMathImpl();

        OptionalInt min = customArrayMath.minNumber(customArray);
        OptionalInt max = customArrayMath.maxNumber(customArray);
        OptionalInt sum = customArrayMath.sum(customArray);

        CustomArrayStatistic customArrayStatistic = new CustomArrayStatistic(min, max, sum);

        Integer arrayId = customArray.getId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.replace(arrayId, customArrayStatistic);
    }
}