package services;

import entities.operations.SimpleOperation;
import entities.operations.SimpleOperationImpl;
import entities.validators.Validator;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.*;

import static org.apache.commons.lang3.math.NumberUtils.*;

public class CalculatorServiceImpl implements CalculatorService {
    private StorageService storageService;
    private Validator validator = new Validator();
    private SimpleOperation<Double> operation = new SimpleOperationImpl();

    public CalculatorServiceImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void calculateExpression(){
        List<String> expression = getExpression();
        List<String> expressionInPostfixNotation = getExpressionInPostfixNotation(expression);

        Stack<Double> stack = new Stack<>();
        for (String token : expressionInPostfixNotation) {
            if (isCreatable(token)) {
                stack.push(Double.parseDouble(token));
            } else if (validator.isOperator(token)) {
                double secondNumber = stack.pop();
                double firstNumber = stack.pop();
                switch (token) {
                    case "-" :
                        stack.push(operation.subtract(firstNumber, secondNumber));
                        break;
                    case "+" :
                        stack.push(operation.add(firstNumber, secondNumber));
                        break;
                    case "*" :
                        stack.push(operation.multiply(firstNumber, secondNumber));
                        break;
                    case "/" :
                        stack.push(operation.divide(firstNumber, secondNumber));
                        break;
                }
            } else if (validator.isPrefixFunction(token)) {
                double number = stack.pop();
                switch (token) {
                    case "sin" :
                        stack.push(operation.sin(number));
                        break;
                }
            }

        }
        storageService.addInStorage(stack.pop());
        System.out.println("Calculation result: " + storageService.getLastAddedItem());
    }

    @Override
    public List<String> getExpression() {
        Scanner scanner = new Scanner(System.in);
        String expression;
        while (true) {
            System.out.print("Enter an expression to calculate: ");
            if (scanner.hasNextLine()) {
                expression = scanner.nextLine();
                List<String> parsedExpression = getParseExpression(expression);
                if (validator.isValid(parsedExpression)) {
                    return parsedExpression;
                } else {
                    validator.printErrors();
                }
            } else {
                scanner.next();
            }
        }
    }

    @Override
    public List<String> getParseExpression(String expression) {
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(expression));
        tokenizer.ordinaryChar('-');
        tokenizer.ordinaryChar('/');
        List<String> parsedExpression = new LinkedList<>();
        while (true) {
            try {
                if (tokenizer.nextToken() == StreamTokenizer.TT_EOF) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch(tokenizer.ttype) {
                case StreamTokenizer.TT_NUMBER:
                    parsedExpression.add(String.valueOf(tokenizer.nval));
                    break;
                case StreamTokenizer.TT_WORD:
                    parsedExpression.add(tokenizer.sval);
                    break;
                default:  // operator
                    parsedExpression.add(String.valueOf((char) tokenizer.ttype));
            }
        }
        if (parsedExpression.get(0).equals("-") || parsedExpression.get(0).equals("+")) {
            parsedExpression.add(0, "0");
        }
        return parsedExpression;
    }

    @Override
    public List<String> getExpressionInPostfixNotation(List<String> parsedExpression) {
        Deque<String> stack = new ArrayDeque<>();
        List<String> postfixExpression = new ArrayList<>();

        for (String token : parsedExpression) {
            if (isCreatable(token)) {
                postfixExpression.add(token);
            } else if (validator.isOperator(token)) {
                while (!stack.isEmpty() && (getPriority(token) <= getPriority(stack.peek()))) {
                    postfixExpression.add(stack.pop());
                }
                stack.push(token);
            } else if (validator.isPrefixFunction(token)) {
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.peek().equals("(")) {
                    postfixExpression.add(stack.pop());
                    if (stack.isEmpty()) {
                        System.out.println("Скобки не согласованы.");
                        return postfixExpression;
                    }
                }
                stack.pop();
                if (!stack.isEmpty() && validator.isPrefixFunction(stack.peek())) {
                    postfixExpression.add(stack.pop());
                }
            }
        }

        while (!stack.isEmpty()) {
//            postfixExpression.add(stack.pop());
            if (validator.isOperator(stack.peek())) {
                postfixExpression.add(stack.pop());
            } else {
                System.out.println("Скобки не согласованы.");
                return postfixExpression;
            }
        }

//        for (String token : parsedExpression) {
//            if (isCreatable(token)) {
//                expression.add(token);
//            } else if (validator.isPrefixFunction(token)) {
//                stack.push(token);
//            } else if (validator.isOperator(token)) {
//// && - ||
//                while (validator.isPrefixFunction(stack.peek()) ||
//                        getPriority(stack.peek()) >= getPriority(token) ) {
//                    expression.add(stack.pop());
//                }
//                stack.push(token);
//            } else if (token.equals("(")) {
//                stack.push(token);
//            } else if (token.equals(")")) {
//                while (!stack.isEmpty() && !stack.peek().equals("(")) {
////                    if (validator.isPrefixFunction(stack.peek())) {
////                        expression.add(stack.pop());
////                    }
//                    expression.add(stack.pop());
//                }
//                stack.pop();
//            }
//        }
//
//        while (!stack.isEmpty()) {
//            expression.add(stack.pop());
//        }
        return postfixExpression;
    }

    private int getPriority(String token) {
        return switch (token) {
            case "*", "/" -> 3;
            case "+", "-" -> 2;
            case "(" -> 1;
            case ")" -> -1;
            default -> 0;
        };
    }
}
