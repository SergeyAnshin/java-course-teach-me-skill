package validators;

import java.util.*;

import static org.apache.commons.lang3.math.NumberUtils.isCreatable;

public class Validator {
    private Set<String> errors;
    private Set<String> operators = Set.of("*", "+", "/", "-");
    private Set<String> prefixFunction = Set.of("sin", "cos");
    private Set<String> mathCharacters = Set.of(")", "(");

    //допилить
    public boolean isValid(List<String> parsedExpression) {
        if  (parsedExpression != null) {
            errors = new HashSet<>();
            String element;
            for (int i = 0; i < parsedExpression.size(); i++) {
                element = parsedExpression.get(i);

                if (!isOperator(element) && !isPrefixFunction(element)
                        && !isCreatable(element) && !isMathCharacter(element)) {
                    errors.add("Invalid characters");
                }

                if (i < parsedExpression.size() - 1) {
                    String nexElement = parsedExpression.get(i + 1);
                    if (isCreatable(element) &&
                            ( isCreatable(nexElement) || isPrefixFunction(nexElement) || nexElement.equals("("))) {
                        errors.add("Operator is missing");
                    }
                    if (isOperator(element) && isOperator(nexElement)) {
                        errors.add("Operand missing");
                    }

//                isMathCharacter(element)
                    if (element.equals("(") && nexElement.equals(")")) {
                        errors.add("Operand missing");
                    }

                    if (isOperator(element) && nexElement.equals(")")) {
                        errors.add("Operand missing");
                    }

                    if (element.equals(")") && isCreatable(nexElement)) {
                        errors.add("Operator is missing");
                    }
                }

                if (!areBracketsInCorrectPosition(parsedExpression)) {
                    errors.add("Brackets are not placed correctly");
                }
            }
            return errors.isEmpty();
        } else {
            return false;
        }
    }

    public void printErrors() {
        System.out.println(errors.toString());
    }

    public boolean isOperator(String operator) {
        return operators.contains(operator);
    }

    public boolean isPrefixFunction(String function) {
        return prefixFunction.contains(function);
    }

    public boolean isMathCharacter(String character) {
        return mathCharacters.contains(character);
    }

    public boolean areBracketsInCorrectPosition(List<String> parsedExpression) {
        HashMap<String, Integer> openBrackets = new HashMap<>() {{
            put("{", 0);
            put("[", 1);
            put("(", 2);
        }};
        HashMap<String, Integer> closeBrackets = new HashMap<>() {{
            put("}", 0);
            put("]", 1);
            put(")", 2);
        }};

        Stack<String> stack = new Stack<>();
        boolean isCorrect = true;

        for (String element : parsedExpression) {
            if (openBrackets.containsKey(element)) {
                stack.push(element);
            } else if (closeBrackets.containsKey(element)) {
                if (stack.empty() || !openBrackets.get(stack.pop()).equals(closeBrackets.get(element))) {
                    isCorrect = false;
                    break;
                }
            }
        }
        return isCorrect && stack.isEmpty();
    }
}
