package test.vlad.task1.validator;

import by.vlad.task1.validator.CustomValidator;
import by.vlad.task1.validator.impl.CustomValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomValidatorImplTest {
    private CustomValidator validator;

    @BeforeClass
    public void init(){
        validator = CustomValidatorImpl.getInstance();
    }

    @DataProvider(name = "validator")
    public Object[][] createData(){
        return new Object[][]{
                {"023", false},
                {"2 3", false},
                {"  23  ", true},
        };
    }

    @Test(dataProvider = "validator")
    public void testReadDataFromFile(String numberString, boolean expected) {
        boolean actual = validator.validateString(numberString);
        Assert.assertEquals(actual, expected);
    }
}
