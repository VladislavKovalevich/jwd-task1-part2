package by.vlad.task2.reader.impl;

import by.vlad.task2.exception.ReaderException;
import by.vlad.task2.reader.TextFileReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextFileReaderImpl implements TextFileReader {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> readArraysFromFile(String filePath) throws ReaderException {
        List<String> stringList;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)))){

            Stream<String> stringStream = bufferedReader.lines();
            stringList = stringStream.collect(Collectors.toList());

        } catch (FileNotFoundException e){
            //logger.log(Level.ERROR, "File "+ filePath + " was not found", e);
            throw new ReaderException("File "+ filePath + " was not found");
        } catch (IOException e) {
            //logger.log(Level.ERROR, "Failed Input/Output operations while working with file "+ filePath, e);
            throw new ReaderException("Failed Input/Output operations while working with file "+ filePath);
        }

        logger.log(Level.INFO, "Содержимое файла: "+ stringList.toString());

        return stringList;
    }
}
