package by.vlad.task1.service.impl;

import by.vlad.task1.entity.CustomArray;
import by.vlad.task1.service.CustomArrayUtil;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CustomArrayUtilImpl implements CustomArrayUtil {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void changeArrayContent(CustomArray customArray) {
        int[] array = customArray.getArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0){
                array[i] = 0;
            }
        }

        logger.log(Level.INFO, "elements were replaced " + Arrays.toString(array));
        customArray.setArray(array);
    }

    @Override
    public void changeArrayContentStream(CustomArray customArray) {
        int[] array = customArray.getArray();
        int[] changedArray = Arrays.stream(array).map(x -> x < 0 ? 0: x).toArray();
        logger.log(Level.INFO, "elements were replaced (stream) " + Arrays.toString(changedArray));
        customArray.setArray(changedArray);
    }
}
