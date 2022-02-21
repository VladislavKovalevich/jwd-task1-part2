package by.vlad.task1.entity;

import java.util.Arrays;
import java.util.List;

public class CustomArray extends AbstractArray {
    private int[] array;

    public CustomArray(List<Integer> array) {
        super();

        this.array = new int[array.size()];

        for (int i = 0; i < array.size(); i++) {
            this.array[i] = array.get(i);
        }
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

        stringBuilder.append("CustomArray{ array=").append(Arrays.toString(array)).append('}');

        return stringBuilder.toString();
    }
}
