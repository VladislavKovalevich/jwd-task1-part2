package test.vlad.task2.parser;

import by.vlad.task2.parser.CustomParser;
import by.vlad.task2.parser.impl.CustomParserImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomParserImplTest {
    private CustomParser stringParser;

    @BeforeMethod
    public void setUp(){
        stringParser = new CustomParserImpl();
    }

    @DataProvider(name = "parseString")
    public static Object[][] dataCreate(){
        return new Object[][]{{Collections.singletonList("-1, 02, 5, 2 , -6, - 6"), Arrays.asList(-1, 5, 2, -6)} };
    }

    @Test(dataProvider = "parseString")
    public void testReadArrayFromFile(List<String> testString, List<Integer> expected) {
        List<Integer> actual = stringParser.parseArraysList(testString);
        Assert.assertEquals(actual, expected);
    }
}
