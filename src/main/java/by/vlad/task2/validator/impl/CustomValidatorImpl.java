package by.vlad.task2.validator.impl;

import by.vlad.task2.validator.CustomValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomValidatorImpl implements CustomValidator {
    private static CustomValidatorImpl stringValidator;
    private static final String PATTERN_STRING = "^(\\s*(\\-)?[1-9](\\d+)?\\s*)$";

    private CustomValidatorImpl(){
    }

    public static CustomValidatorImpl getInstance() {
        if (stringValidator == null){
            stringValidator = new CustomValidatorImpl();
        }

        return stringValidator;
    }

    @Override
    public boolean validateString(String line) {
        Pattern pattern = Pattern.compile(PATTERN_STRING);
        Matcher matcher = pattern.matcher(line);

        return matcher.matches();
    }
}
