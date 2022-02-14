package test.vlad.task2.service;

import by.vlad.task2.entity.CustomArray;
import by.vlad.task2.service.CustomArraySort;
import by.vlad.task2.service.impl.CustomArraySortImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CustomArraySortImplTest {
    private CustomArraySort customArraySort;

    @BeforeClass
    public void init(){
        customArraySort = new CustomArraySortImpl();
    }

    @DataProvider(name = "sortData")
    public Object[][] createSortData(){
        return new Object[][]{
                {new CustomArray(Arrays.asList(2, 0, -1, -5, 1)), new int[]{-5, -1, 0, 1, 2}},
                {new CustomArray(Arrays.asList(0, -4, -6, 2, 1)), new int[]{-6, -4, 0, 1, 2}}
        };
    }

    @Test(dataProvider = "sortData")
    public void testSelectionSort(CustomArray customArray, int[] expected){
        customArraySort.selectionSort(customArray);
        Assert.assertEquals(customArray.getArray(), expected);
    }

    @Test(dataProvider = "sortData")
    public void testBubbleSort(CustomArray customArray, int[] expected){
        customArraySort.bubbleSort(customArray);
        int[] actual = customArray.getArray();
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "sortData")
    public void testInsertionSort(CustomArray customArray, int[] expected){
        customArraySort.insertionSort(customArray);
        int[] actual = customArray.getArray();
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "sortData")
    public void testStreamSort(CustomArray customArray, int[] expected){
        customArraySort.streamSort(customArray);
        int[] actual = customArray.getArray();
        Assert.assertEquals(actual, expected);
    }
}
