package by.vlad.task1.service.impl;

import by.vlad.task1.entity.CustomArray;
import by.vlad.task1.service.CustomArrayMath;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayMathImpl implements CustomArrayMath {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public OptionalInt minNumber(CustomArray customArray) {
        int[] array = customArray.getArray();
        int minValue = Integer.MAX_VALUE;

        if (array.length == 0){
            return OptionalInt.empty();
        }

        for (int i: array){
            if (i < minValue){
                minValue = i;
            }
        }

        logger.log(Level.INFO, "min = " + minValue);
        return OptionalInt.of(minValue);
    }

    @Override
    public OptionalInt minNumberStream(CustomArray customArray) {
        int[] array = customArray.getArray();
        OptionalInt min = Arrays.stream(array).min();
        logger.log(Level.INFO, "min (stream) = " + min);
        return min;
    }

    @Override
    public OptionalInt maxNumber(CustomArray customArray) {
        int[] array = customArray.getArray();
        int maxValue = Integer.MIN_VALUE;

        if (array.length == 0){
            return OptionalInt.empty();
        }

        for (int i: customArray.getArray()){
            if (i > maxValue){
                maxValue = i;
            }
        }

        logger.log(Level.INFO, "max = " + maxValue);
        return OptionalInt.of(maxValue);
    }

    @Override
    public OptionalInt maxNumberStream(CustomArray customArray) {
        int[] array = customArray.getArray();
        OptionalInt max = Arrays.stream(array).max();
        logger.log(Level.INFO, "max (stream) = " + max);
        return max;
    }

    @Override
    public OptionalDouble averageValue(CustomArray customArray) {
        double averageValue;
        int sum = 0;
        int[] array = customArray.getArray();

        if (array.length == 0){
            return OptionalDouble.empty();
        }

        for (int element : array) {
            sum += element;
        }

        averageValue = (double) sum / array.length;

        logger.log(Level.INFO, "average = " + averageValue);
        return OptionalDouble.of(averageValue);
    }

    @Override
    public OptionalDouble averageValueStream(CustomArray customArray) {
        int[] array = customArray.getArray();
        OptionalDouble average = Arrays.stream(array).average();
        logger.log(Level.INFO, "average (stream) = " + average);
        return average;
    }

    @Override
    public OptionalInt sum(CustomArray customArray) {
        int[] array = customArray.getArray();
        int sum = 0;

        if (array.length == 0){
            return OptionalInt.empty();
        }

        for (int i : array) {
            sum += i;
        }

        logger.log(Level.INFO, "sum = " + sum);
        return OptionalInt.of(sum);
    }

    @Override
    public OptionalInt sumStream(CustomArray customArray) {
        int[] array = customArray.getArray();

        if (array.length == 0){
            return OptionalInt.empty();
        }

        int sum = Arrays.stream(array).sum();
        logger.log(Level.INFO, "sum (stream) = " + sum);
        return OptionalInt.of(sum);
    }

    @Override
    public long countOfPositive(CustomArray customArray) {
        long positiveNumbers = 0;

        for (int i : customArray.getArray()) {
            if (i >= 0) {
                positiveNumbers++;
            }
        }

        logger.log(Level.INFO, "count of positive = " + positiveNumbers);

        return positiveNumbers;
    }

    @Override
    public long countOfPositiveStream(CustomArray customArray) {
        int[] array = customArray.getArray();
        long result = Arrays.stream(array).filter(x -> x > 0).count();
        logger.log(Level.INFO, "count of positive (stream) = " + result);
        return result;
    }

    @Override
    public long countOfNegative(CustomArray customArray) {
        long negativeNumbers = 0;

        for (int i : customArray.getArray()) {
            if (i < 0) {
                negativeNumbers++;
            }
        }

        logger.log(Level.INFO, "count of negative = " + negativeNumbers);

        return negativeNumbers;
    }

    @Override
    public long countOfNegativeStream(CustomArray customArray) {
        int[] array = customArray.getArray();
        long result = Arrays.stream(array).filter(x -> x < 0).count();
        logger.log(Level.INFO, "count of negative (stream) = " + result);
        return result;
    }
}
