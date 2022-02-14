package by.vlad.task2.repository;

import by.vlad.task2.entity.CustomArray;

@FunctionalInterface
public interface Specification {
    boolean specify(CustomArray item);
}
