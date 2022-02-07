package org.anshin.enums;

import java.util.Arrays;
import java.util.Objects;

public enum Operation {
    SUM(1), SUBTRACT(2), DIVIDE(3), MULTIPLY(4);

    private int DBId;

    Operation(int DBId) {
        this.DBId = DBId;
    }

    public int getDBId() {
        return DBId;
    }

    public static boolean contain(String operation) {
        return Arrays.stream(values())
                .map(Objects::toString)
                .anyMatch(s -> s.equalsIgnoreCase(operation));
    }

    public double calculate(double firstValue, double secondValue) {
        double result;
        switch (this) {
            case SUM:
                result = firstValue + secondValue;
                break;
            case SUBTRACT:
                result = firstValue - secondValue;
                break;
            case DIVIDE:
                result = firstValue / secondValue;
                break;
            case MULTIPLY:
                result = firstValue * secondValue;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return result;
    }
}
