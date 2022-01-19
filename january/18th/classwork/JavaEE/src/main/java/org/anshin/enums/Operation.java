package org.anshin.enums;

import java.util.Arrays;
import java.util.Objects;

public enum Operation {
    ADD, SUBTRACT, DIVIDE, MULTIPLY;

    public static boolean contain(String operation) {
        return Arrays.stream(values())
                .map(Objects::toString)
                .anyMatch(s -> s.equalsIgnoreCase(operation));
    }

    public double calculate(double firstValue, double secondValue) {
        double result;
        switch (this) {
            case ADD:
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
