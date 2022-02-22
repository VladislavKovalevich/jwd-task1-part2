package test.vlad.task1.repository;

import by.vlad.task1.entity.CustomArray;
import by.vlad.task1.repository.Repository;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class RepositoryTest {
    private Repository repository;

    @BeforeClass
    public void init(){
        repository = Repository.getInstance();
    }

    @DataProvider(name = "repository")
    public Object[][] createData(){
        return new Object[][]{
                {repository, new CustomArray(Arrays.asList(1, 0, 2, 3))}
        };
    }

    @Test(dataProvider = "repository")
    public void addToRepository(Repository repository, CustomArray expected) {
        CustomArray actual;
        repository.add(expected);
        actual = repository.get(0);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "repository")
    public void removeRepository(Repository repository, CustomArray customArray) {
        boolean actual;
        repository.add(customArray);
        actual = repository.remove(customArray);
        Assert.assertTrue(actual);
    }
}
