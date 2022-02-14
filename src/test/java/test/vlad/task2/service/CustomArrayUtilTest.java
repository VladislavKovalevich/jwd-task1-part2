package test.vlad.task2.service;

import by.vlad.task2.entity.CustomArray;
import by.vlad.task2.service.CustomArrayUtil;
import by.vlad.task2.service.impl.CustomArrayUtilImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CustomArrayUtilTest {
    private CustomArrayUtil customArrayUtil;

    @BeforeClass
    public void init(){
        customArrayUtil = new CustomArrayUtilImpl();
    }

    @DataProvider(name = "changeArrayData")
    public Object[][] createData(){
        return new Object[][]{
                {new CustomArray(Arrays.asList(2, -2, -3, 0, -5)), new int[]{2, 0, 0, 0, 0}},
                {new CustomArray(Arrays.asList(2, 3, 4, 0, 9)), new int[]{2, 3, 4, 0, 9}}
        };
    }

    @Test(dataProvider = "changeArrayData")
    public void testArrayChange(CustomArray customArray, int[] expected){
        customArrayUtil.changeArrayContent(customArray);
        int[] actual = customArray.getArray();
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "changeArrayData")
    public void testArrayChangeStream(CustomArray customArray, int[] expected){
        customArrayUtil.changeArrayContentStream(customArray);
        int[] actual = customArray.getArray();
        Assert.assertEquals(actual, expected);
    }
}
