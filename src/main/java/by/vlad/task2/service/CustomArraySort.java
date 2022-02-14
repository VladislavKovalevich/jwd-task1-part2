package by.vlad.task2.service;

import by.vlad.task2.entity.CustomArray;

public interface CustomArraySort {
    void bubbleSort(CustomArray customArray);
    void selectionSort(CustomArray customArray);
    void insertionSort(CustomArray customArray);
    void streamSort(CustomArray customArray);
}
