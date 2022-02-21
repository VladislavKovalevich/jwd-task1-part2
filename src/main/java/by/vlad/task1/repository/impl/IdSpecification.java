package by.vlad.task1.repository.impl;

import by.vlad.task1.entity.CustomArray;
import by.vlad.task1.repository.Specification;

public class IdSpecification implements Specification {
    private Integer id;

    public IdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean specify(CustomArray item) {
        return item.getId() == id;
    }
}