package by.vlad.task1.parser.impl;

import by.vlad.task1.parser.CustomParser;
import by.vlad.task1.validator.impl.CustomValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomParserImpl implements CustomParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String DELIMITER = ",";

    @Override
    public Map<Integer, List<Integer>> parseStringsList(List<String> arraysString) {
        Map<Integer, List<Integer>> arraysMap = new HashMap<>();
        CustomValidatorImpl stringValidator = CustomValidatorImpl.getInstance();

        Integer key = 0;
        String curr;
        List<Integer> currentArray;

        for (String array : arraysString) {

            currentArray = new ArrayList<>();

            for (String number : array.split(DELIMITER)) {
                if (stringValidator.validateString(number)) {
                    curr = number.trim();
                    logger.log(Level.INFO, "valid number: " + curr);
                    int currNumber = Integer.parseInt(curr);
                    currentArray.add(currNumber);
                } else {
                    logger.log(Level.INFO, "invalid number: " + number.trim());
                }
            }

            arraysMap.put(key, currentArray);
            key++;
        }

        return arraysMap;
    }
}
