package by.vlad.task2.entity;

import by.vlad.task2.observer.CustomArrayEvent;
import by.vlad.task2.observer.Observable;
import by.vlad.task2.observer.Observer;
import by.vlad.task2.util.IdGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomArray implements Observable {
    private Integer id;
    private int[] array;
    private List<Observer> observerList = new ArrayList<>();

    public CustomArray(List<Integer> array) {
        this.array = new int[array.size()];

        for (int i = 0; i < array.size(); i++) {
            this.array[i] = array.get(i);
        }

        this.id = IdGenerator.getInstance().getId();
    }

    public Integer getId() {
        return id;
    }

    public int[] getArray() {
        return array.clone();
    }

    public void setArray(int[] array) {
        this.array = array;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("CustomArray{" + "array=").append(Arrays.toString(array)).append('}');

        return stringBuilder.toString();
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if (!observerList.isEmpty()){
            for (Observer ob: observerList) {
                ob.parameterChanged(new CustomArrayEvent(this));
            }
        }
    }
}
