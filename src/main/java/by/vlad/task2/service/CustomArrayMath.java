package by.vlad.task2.service;

import by.vlad.task2.entity.CustomArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface CustomArrayMath {
    OptionalInt minNumber(CustomArray customArray);
    OptionalInt minNumberStream(CustomArray customArray);
    OptionalInt maxNumber(CustomArray customArray);
    OptionalInt maxNumberStream(CustomArray customArray);

    OptionalDouble averageValue(CustomArray customArray);
    OptionalDouble averageValueStream(CustomArray customArray);

    OptionalInt sum(CustomArray customArray);
    OptionalInt sumStream(CustomArray customArray);

    long countOfPositive(CustomArray customArray);
    long countOfPositiveStream(CustomArray customArray);
    long countOfNegative(CustomArray customArray);
    long countOfNegativeStream(CustomArray customArray);
}
