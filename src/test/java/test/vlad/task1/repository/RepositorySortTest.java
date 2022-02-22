package test.vlad.task1.repository;

import by.vlad.task1.entity.CustomArray;
import by.vlad.task1.entity.comparator.ArrayFirstItemComparator;
import by.vlad.task1.entity.comparator.ArrayLengthComparator;
import by.vlad.task1.entity.comparator.IdComparator;
import by.vlad.task1.repository.Repository;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RepositorySortTest {
    private Repository repository;

    @BeforeClass
    public void init(){
        repository = Repository.getInstance();

        repository.add(new CustomArray(Arrays.asList(21, 10, 2, 3)));
        repository.add(new CustomArray(Arrays.asList(4, 0, 15, 2, 3)));
        repository.add(new CustomArray(Arrays.asList(14, 0, 2, 3)));
        repository.add(new CustomArray(Arrays.asList(9, 1, 32)));
    }

    @DataProvider(name = "queryRepository")
    public Object[][] createQueryRepositoryData(){

        return new Object[][]{
                {repository, new ArrayFirstItemComparator(),
                        Arrays.asList(new CustomArray(Arrays.asList(4, 0, 15, 2, 3)),
                                new CustomArray(Arrays.asList(9, 1, 32)),
                                new CustomArray(Arrays.asList(14, 0, 2, 3)),
                                new CustomArray(Arrays.asList(21, 10, 2, 3)))
                },
                {repository, new ArrayLengthComparator(),
                        Arrays.asList(new CustomArray(Arrays.asList(9, 1, 32)),
                                new CustomArray(Arrays.asList(21, 10, 2, 3)),
                                new CustomArray(Arrays.asList(14, 0, 2, 3)),
                                new CustomArray(Arrays.asList(4, 0, 15, 2, 3)))
                },

                {repository, new IdComparator(),
                        Arrays.asList(new CustomArray(Arrays.asList(21, 10, 2, 3)),
                                new CustomArray(Arrays.asList(4, 0, 15, 2, 3)),
                                new CustomArray(Arrays.asList(14, 0, 2, 3)),
                                new CustomArray(Arrays.asList(9, 1, 32)))
                }
        };
    }

    @Test(dataProvider = "queryRepository")
    public void sortRepository(Repository repository, Comparator<CustomArray> comparator, List<CustomArray> expected) {
        List<CustomArray> actual = repository.sort(comparator);
        Assert.assertEquals(actual, expected);
    }
}
