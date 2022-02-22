package test.vlad.task1.repository;

import by.vlad.task1.entity.CustomArray;
import by.vlad.task1.repository.Repository;
import by.vlad.task1.repository.Specification;
import by.vlad.task1.repository.impl.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class RepositoryQueryTest {
    private Repository repository;

    @BeforeClass
    public void init(){
        repository = Repository.getInstance();

          repository.add(new CustomArray(Arrays.asList(1, 0, 2, 3)));
          repository.add(new CustomArray(Arrays.asList(4, 0, 0, 2, 3)));
          repository.add(new CustomArray(Arrays.asList(4, 0, 2, 3)));
          repository.add(new CustomArray(Arrays.asList(9, 1, 3)));
    }

    @DataProvider(name = "queryRepository")
    public Object[][] createQueryRepositoryData(){

        return new Object[][]{
                {repository, new IdSpecification(1),
                        Arrays.asList(new CustomArray(Arrays.asList(1, 0, 2, 3)))
                },
                {repository, new ArrayLengthSpecification(5),
                        Arrays.asList(new CustomArray(Arrays.asList(1, 0, 2, 3)),
                                new CustomArray(Arrays.asList(4, 0, 0, 2, 3)),
                                new CustomArray(Arrays.asList(4, 0, 2, 3)),
                                new CustomArray(Arrays.asList(9, 1, 3)))
                },

                {repository, new ArrayMaxSpecification(4),
                        Arrays.asList(new CustomArray(Arrays.asList(4, 0, 0, 2, 3)),
                                new CustomArray(Arrays.asList(4, 0, 2, 3)))
                },
                {repository, new ArrayMinSpecification(1),
                        Arrays.asList(new CustomArray(Arrays.asList(9, 1, 3)))
                },
                {repository, new ArraySumSpecification(12),
                        Arrays.asList(new CustomArray(Arrays.asList(9, 1, 3)))
                }
        };
    }

    @Test(dataProvider = "queryRepository")
    public void queryRepository(Repository repository, Specification specification, List<CustomArray> expected) {
        List<CustomArray> actual = repository.query(specification);
        Assert.assertEquals(actual, expected);
    }
}
