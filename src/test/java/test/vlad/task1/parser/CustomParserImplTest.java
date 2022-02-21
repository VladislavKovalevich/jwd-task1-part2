package test.vlad.task1.parser;

import by.vlad.task1.parser.CustomParser;
import by.vlad.task1.parser.impl.CustomParserImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CustomParserImplTest {
    private CustomParser stringParser;

    @BeforeMethod
    public void setUp(){
        stringParser = new CustomParserImpl();
    }

    @DataProvider(name = "parseString")
    public static Object[][] dataCreate(){
        return new Object[][]{
                {
                    Collections.singletonList("-1, 02, 5, 2 , -6, - 6"),
                    Collections.singletonMap(0, Arrays.asList(-1, 5, 2, -6))
                }
        };
    }

    @Test(dataProvider = "parseString")
    public void parseStringToArray(List<String> testString, Map<Integer, List<Integer>> expected) {
        Map<Integer, List<Integer>> actual = stringParser.parseStringsList(testString);
        Assert.assertEquals(actual, expected);
    }
}
