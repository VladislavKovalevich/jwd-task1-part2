package by.vlad.task2.entity;

import java.util.Objects;
import java.util.OptionalInt;

public class CustomArrayStatistic {
    private OptionalInt min;
    private OptionalInt max;
    private OptionalInt sum;

    public CustomArrayStatistic(OptionalInt min, OptionalInt max, OptionalInt sum) {
        this.min = min;
        this.max = max;
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArrayStatistic that = (CustomArrayStatistic) o;
        return Objects.equals(min, that.min) &&
                Objects.equals(max, that.max) &&
                Objects.equals(sum, that.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max, sum);
    }

    @Override
    public String toString() {
        return "CustomArrayStatistic{" +
                "min=" + min +
                ", max=" + max +
                ", sum=" + sum +
                '}';
    }
}
