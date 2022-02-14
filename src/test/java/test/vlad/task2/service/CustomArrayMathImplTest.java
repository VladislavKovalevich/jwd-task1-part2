package test.vlad.task2.service;

import by.vlad.task2.entity.CustomArray;
import by.vlad.task2.service.CustomArrayMath;
import by.vlad.task2.service.impl.CustomArrayMathImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayMathImplTest {
    private CustomArrayMath customArrayMath;

    @BeforeClass
    public void init() {
        customArrayMath = new CustomArrayMathImpl();
    }

    @DataProvider(name="sumProvider")
    public Object[][] createSumObjectData(){
        return new Object[][]{
                {new CustomArray(Collections.emptyList()), OptionalInt.empty()},
                {new CustomArray(Arrays.asList(2, 3, 4, 5)), OptionalInt.of(14)}
        };
    }

    @DataProvider(name="negativeCounterProvider")
    public Object[][] createNegCounterObjectData(){
        return new Object[][]{
                {new CustomArray(Collections.emptyList()), 0},
                {new CustomArray(Arrays.asList(-2, -3, 4, -5)), 3}
        };
    }

    @DataProvider(name="positiveCounterProvider")
    public Object[][] createPosCounterObjectData(){
        return new Object[][]{
                {new CustomArray(Collections.emptyList()), 0},
                {new CustomArray(Arrays.asList(-2, -3, 4, -5)), 1}
        };
    }

    @DataProvider(name="averageProvider")
    public Object[][] createAverageObjectData(){
        return new Object[][]{
                {new CustomArray(Collections.emptyList()), OptionalDouble.empty()},
                {new CustomArray(Arrays.asList(2, 3, 4)), OptionalDouble.of(3.0)}
        };
    }

    @DataProvider(name="minProvider")
    public Object[][] createMinObjectData(){
        return new Object[][]{
                {new CustomArray(Collections.emptyList()), OptionalInt.empty()},
                {new CustomArray(Arrays.asList(-2, -3, 4, -5)), OptionalInt.of(-5)}
        };
    }

    @DataProvider(name="maxProvider")
    public Object[][] createMaxObjectData(){
        return new Object[][]{
                {new CustomArray(Collections.emptyList()), OptionalInt.empty()},
                {new CustomArray(Arrays.asList(-2, -3, 4, -5)), OptionalInt.of(4)}
        };
    }

    @Test(dataProvider = "sumProvider")
    public void testSumOperation(CustomArray customArray, OptionalInt expected){
        OptionalInt actual = customArrayMath.sum(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "sumProvider")
    public void testSumStream(CustomArray customArray, OptionalInt expected){
        OptionalInt actual = customArrayMath.sumStream(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "averageProvider")
    public void testAverageValue(CustomArray customArray, OptionalDouble expected){
        OptionalDouble actual = customArrayMath.averageValue(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "averageProvider")
    public void testAverageValueStream(CustomArray customArray, OptionalDouble expected){
        OptionalDouble actual = customArrayMath.averageValueStream(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "minProvider")
    public void testMinNumber(CustomArray customArray, OptionalInt expected){
        OptionalInt actual = customArrayMath.minNumber(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "minProvider")
    public void testMinNumberStream(CustomArray customArray, OptionalInt expected){
        OptionalInt actual = customArrayMath.minNumberStream(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "maxProvider")
    public void testMaxNumber(CustomArray customArray, OptionalInt expected){
        OptionalInt actual = customArrayMath.maxNumber(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "maxProvider")
    public void testMaxNumberStream(CustomArray customArray, OptionalInt expected){
        OptionalInt actual = customArrayMath.maxNumberStream(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "positiveCounterProvider")
    public void testCountOfPositiveNumbers(CustomArray customArray, long expected){
        long actual = customArrayMath.countOfPositive(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "positiveCounterProvider")
    public void testCountOfPositiveNumbersStream(CustomArray customArray, long expected){
        long actual = customArrayMath.countOfPositiveStream(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "negativeCounterProvider")
    public void testCountOfNegativeNumbers(CustomArray customArray, long expected){
        long actual = customArrayMath.countOfNegative(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "negativeCounterProvider")
    public void testCountOfNegativeNumbersStream(CustomArray customArray, long expected){
        long actual = customArrayMath.countOfNegativeStream(customArray);
        Assert.assertEquals(actual, expected);
    }
}
