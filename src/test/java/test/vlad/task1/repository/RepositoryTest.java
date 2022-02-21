package test.vlad.task1.repository;

import by.vlad.task1.entity.CustomArray;
import by.vlad.task1.repository.Repository;
import by.vlad.task1.repository.Specification;
import by.vlad.task1.repository.impl.ArrayLengthSpecification;
import by.vlad.task1.repository.impl.ArrayMaxSpecification;
import by.vlad.task1.repository.impl.ArrayMinSpecification;
import by.vlad.task1.repository.impl.IdSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class RepositoryTest {
    private Repository repository;

    @BeforeClass
    public void init(){
        repository = Repository.getInstance();
    }

    @DataProvider(name = "repository")
    public Object[][] createData(){
        return new Object[][]{
                {repository, new CustomArray(Arrays.asList(2, 3, 4, 4, 5))}
        };
    }

    @DataProvider(name = "queryRepository")
    public Object[][] createQueryRepositoryData(){
        repository.add(new CustomArray(Arrays.asList(1, 0, 2, 3)));
        repository.add(new CustomArray(Arrays.asList(4, 0, 0, 2, 3)));
        repository.add(new CustomArray(Arrays.asList(4, 0, 2, 3)));
        repository.add(new CustomArray(Arrays.asList(9, 1, 3)));

        return new Object[][]{
                {repository, new IdSpecification(1), 1},
                {repository, new ArrayLengthSpecification(5), 3},
                {repository, new ArrayMaxSpecification(4), 1},
                {repository, new ArrayMinSpecification(1), 1}
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

    @Test(dataProvider = "queryRepository")
    public void queryRepository(Repository repository, Specification specification, int expected) {
        List<CustomArray> customArrays = repository.query(specification);
        Assert.assertEquals(customArrays.size(), expected);
    }
}
