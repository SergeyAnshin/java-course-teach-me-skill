package org.anshin.enums;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public enum Operation {
    SUM, SUBTRACT, DIVIDE, MULTIPLY;

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
