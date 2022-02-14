package by.vlad.task2.parser.impl;

import by.vlad.task2.parser.CustomParser;
import by.vlad.task2.validator.impl.CustomValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomParserImpl implements CustomParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String DELIMITER = ",";

    @Override
    public List<Integer> parseArraysList(List<String> arraysString) {
        List<Integer> arrayList = new ArrayList<Integer>();
        CustomValidatorImpl stringValidator = CustomValidatorImpl.getInstance();

        String curr;
        for (String array : arraysString) {
            for (String number : array.split(DELIMITER)) {
                if (stringValidator.validateString(number)) {
                    curr = number.trim();
                    logger.log(Level.INFO, "valid number: " + curr);
                    int currNumber = Integer.parseInt(curr);
                    arrayList.add(currNumber);
                } else {
                    logger.log(Level.INFO, "invalid number: " + number.trim());
                }
            }
        }

        if (arrayList.size() == 0){
            logger.log(Level.WARN, "list is empty");
        }

        return arrayList;
    }
}
