package services;

import java.util.List;

public interface CalculatorService {

    List<String> getExpression();

    void calculateExpression();

    List<String> getExpressionInPostfixNotation(List<String> expression);

    List<String> getParseExpression(String expression);

}
