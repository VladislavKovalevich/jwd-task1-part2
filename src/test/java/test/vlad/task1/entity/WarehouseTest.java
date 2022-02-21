package test.vlad.task1.entity;

import by.vlad.task1.entity.CustomArray;
import by.vlad.task1.entity.CustomArrayStatistic;
import by.vlad.task1.entity.Warehouse;
import by.vlad.task1.observer.impl.CustomArrayObserverImpl;
import by.vlad.task1.repository.Repository;
import by.vlad.task1.service.CustomArrayMath;
import by.vlad.task1.service.impl.CustomArrayMathImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.OptionalInt;

public class WarehouseTest {
    private Repository repository;
    private Warehouse warehouse;

    @BeforeClass
    public void init(){
        CustomArrayMath customArrayMath = new CustomArrayMathImpl();
        CustomArrayObserverImpl customArrayObserver = new CustomArrayObserverImpl();
        CustomArrayStatistic customArrayStatistic;
        CustomArray customArray;

        repository = Repository.getInstance();
        warehouse = Warehouse.getInstance();

        customArray = new CustomArray(Arrays.asList(1, 0, 2, 3));
        customArray.attach(customArrayObserver);
        customArrayStatistic = new CustomArrayStatistic(
                customArrayMath.minNumber(customArray),
                customArrayMath.maxNumber(customArray),
                customArrayMath.sumStream(customArray));

        repository.add(customArray);
        warehouse.put(customArray.getId(), customArrayStatistic);
    }

    @DataProvider(name = "observer")
    public Object[][] createData(){
        return new Object[][]{
                {
                    repository,
                    new int[]{-1, 0, 1, 29},
                    warehouse,
                    new CustomArrayStatistic(OptionalInt.of(-1), OptionalInt.of(29), OptionalInt.of(29))
                }
        };
    }

    @Test(dataProvider = "observer")
    public void testObserverLogic(Repository repository, int[] editArray, Warehouse warehouse, CustomArrayStatistic expected){
        repository.get(0).setArray(editArray);
        CustomArrayStatistic actual = warehouse.get(1);
        Assert.assertEquals(actual, expected);
    }

}
