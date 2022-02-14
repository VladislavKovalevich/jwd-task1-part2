package by.vlad.task2.reader;

import by.vlad.task2.exception.ReaderException;

import java.util.List;

public interface TextFileReader {
    List<String> readArraysFromFile(String filePath) throws ReaderException;
}
