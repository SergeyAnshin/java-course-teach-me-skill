package org.sergey.ans.enums;

import java.util.Arrays;
import java.util.Objects;

public enum Operation {
    SUM, SUBTRACT, DIVIDE, MULTIPLY;

    public static boolean contain(String operation) {
        return Arrays.stream(values())
                .map(Objects::toString)
                .anyMatch(s -> s.trim().equalsIgnoreCase(operation));
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
