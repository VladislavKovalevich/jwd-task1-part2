package test.vlad.task1.reader;

import by.vlad.task1.exception.ReaderException;
import by.vlad.task1.reader.TextFileReader;
import by.vlad.task1.reader.impl.TextFileReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TextFileReaderImplTest {
    private TextFileReader textFileReader;

    @BeforeClass
    public void init(){
        textFileReader = new TextFileReaderImpl();
    }

    @DataProvider(name = "fileReader")
    public Object[][] createData(){
        return new Object[][]{
                {
                    "src\\main\\resources\\arrays.txt",
                    Arrays.asList("2, 4, x3, - 5, -3, -9, 0",
                            "31, 29 0, 09, 5, 7, -3",
                            "",
                            "25, 45, -98, -7")
                }
        };
    }

    @Test(dataProvider = "fileReader")
    public void testReadDataFromFile(String path, List<String> expected) throws ReaderException {
        List<String> actual = textFileReader.readArraysFromFile(path);
        Assert.assertEquals(actual, expected);
    }
}
