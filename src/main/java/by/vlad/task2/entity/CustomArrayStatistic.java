package by.vlad.task2.entity;

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

    public OptionalInt getMin() {
        return min;
    }

    public OptionalInt getMax() {
        return max;
    }

    public OptionalInt getSum() {
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomArrayStatistic that = (CustomArrayStatistic) o;

        if (!min.equals(that.min)) return false;
        if (!max.equals(that.max)) return false;
        return sum.equals(that.sum);
    }

    @Override
    public int hashCode() {
        int result = min.hashCode();
        result = 31 * result + max.hashCode();
        result = 31 * result + sum.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("CustomArrayStatistic{ min=")
                .append(min)
                .append(", max=")
                .append(max)
                .append(", sum=")
                .append(sum)
                .append('}').toString();
    }
}
