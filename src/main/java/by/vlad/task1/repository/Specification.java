package by.vlad.task1.repository;

import by.vlad.task1.entity.CustomArray;

@FunctionalInterface
public interface Specification {
    boolean specify(CustomArray item);
}
