package com.charakhovich.utl;

import com.charakhovich.interpretator.Context;
import com.charakhovich.interpretator.MathExpression;
import com.charakhovich.interpretator.NonTerminalOperation;

import java.util.*;

public class ReversePolishNotation {
    private static final String NUMBER = "\\d";
    private static final String MATH_OPERATOR_REGEXP = "[\\^+*/\\-]";
    private static final String BRACKET_OPEN = "\\(";
    private static final String BRACKET_CLOSE = "\\)";
    private static final String SPLITTER = "\\s";
    private static final char NULL_CHAR = '\u0000';
    private static final String NUMBER_SIGN = "[+\\-]";
    private static final char NUMBER_ZERO = '0';
    private static final String REAL_NUMBER = "[+-]?\\d{1,5}([.]?\\d{0,2})?";
    private static final Map<Character, OperatorParams> MATH_OPERATORS = initMap();

    private static Map<Character, OperatorParams> initMap() {
        Map<Character, OperatorParams> map = new HashMap<>();
        map.put('^', new OperatorParams(OperatorPriority.HIGH, OperatorAssociativity.RIGHT));
        map.put('*', new OperatorParams(OperatorPriority.MEDIUM, OperatorAssociativity.LEFT));
        map.put('/', new OperatorParams(OperatorPriority.MEDIUM, OperatorAssociativity.LEFT));
        map.put('+', new OperatorParams(OperatorPriority.LOW, OperatorAssociativity.LEFT));
        map.put('-', new OperatorParams(OperatorPriority.MEDIUM, OperatorAssociativity.LEFT));
        return Collections.unmodifiableMap(map);
    }

    public static String convertTo(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder out = new StringBuilder();
        char[] symbolArray = str.toCharArray();
        char previousSymbol = NULL_CHAR;
        for (char symbol : symbolArray
        ) {
            if (String.valueOf(symbol).matches(NUMBER)) {
                if (String.valueOf(previousSymbol).matches(NUMBER)) {
                    out.append(symbol);
                } else {
                    out.append(SPLITTER).append(symbol);
                }
            }
            if (String.valueOf(symbol).matches(MATH_OPERATOR_REGEXP)) {
                boolean addZeroToOutString = String.valueOf(symbol).matches(NUMBER_SIGN) &&
                        (String.valueOf(previousSymbol).matches(BRACKET_OPEN) || String.valueOf(previousSymbol).matches(SPLITTER));
                if (addZeroToOutString) {
                    out.append(NUMBER_ZERO);
                }
                boolean flag = !stack.isEmpty();
                while (flag && (!String.valueOf(stack.peekFirst()).matches(BRACKET_OPEN))) {
                    char lastOperator = stack.poll();
                    OperatorPriority lastOperationPriority = MATH_OPERATORS.get(lastOperator).getPriority();
                    OperatorPriority currentOperationPriority = MATH_OPERATORS.get(symbol).getPriority();
                    OperatorAssociativity currentAssociativity = MATH_OPERATORS.get(symbol).getAssociativity();
                    boolean putLastOperatorInOutString;
                    putLastOperatorInOutString = (lastOperationPriority == currentOperationPriority && currentAssociativity == OperatorAssociativity.LEFT)
                            || (lastOperationPriority.getValuePriority() > lastOperationPriority.getValuePriority());
                    if (putLastOperatorInOutString) {
                        out.append(SPLITTER).append(lastOperator);
                        flag = !stack.isEmpty();
                    } else {
                        stack.push(lastOperator);
                        flag = false;
                    }
                }
                stack.push(symbol);
            }
            if (String.valueOf(symbol).matches(BRACKET_OPEN)) {
                stack.push(symbol);
            }
            if (String.valueOf(symbol).matches(BRACKET_CLOSE)) {
                boolean flag = true;
                while (flag) {
                    char tempChar = stack.pop();
                    if (!String.valueOf(tempChar).matches(BRACKET_OPEN)) {
                        out.append(SPLITTER).append(tempChar);
                    } else {
                        flag = false;
                    }
                }
            }
            previousSymbol = symbol;
        }
        while (!stack.isEmpty()) {
            char operatorFromStack = stack.poll();
            out.append(SPLITTER).append(operatorFromStack);
        }
        return out.toString();
    }

    /* public static Double calculateReversePolishNotation(String str) {
         double resultCalculate = 0;
         Deque<Double> stack = new LinkedList<>();
         String[] arrayElements = str.split(SPLITTER);
         for (String element : arrayElements
         ) {
             if (element.matches(REAL_NUMBER)) {
                 stack.push(Double.parseDouble(element));
             }
             if (element.matches(MATH_OPERATOR_REGEXP)) {
                 double result = 0;
                 double secondElement = stack.poll();
                 double firstElement = stack.poll();
                 switch (element) {
                     case "*":
                         result = firstElement * secondElement;
                         break;
                     case "/":
                         result = firstElement / secondElement;
                         break;
                     case "+":
                         result = firstElement + secondElement;
                         break;
                     case "-":
                         result = firstElement - secondElement;
                         break;
                     default:
                         throw new IllegalStateException("Unexpected value: " + element);
                 }
                 stack.push(result);
             }
         }
         return stack.poll();
     }
 */
    public static double calculate(String str) {
        Context context = new Context<Double>();
        String[] arrayElements = str.split(SPLITTER);
        for (String element : arrayElements
        ) {
            if (element.matches(REAL_NUMBER)) {
                NonTerminalOperation number = new NonTerminalOperation(Double.parseDouble(element));
                context.calculate(number);
            }
            if (element.matches(MATH_OPERATOR_REGEXP)) {
                switch (element) {
                    case "*":
                        MathExpression<Double> Multiplication = x -> {
                            x.push(x.poll() * x.poll());
                        };
                        context.calculate(Multiplication);
                        break;
                    case "/":
                        MathExpression<Double> Division = x -> x.push(1 / x.poll() * x.poll());
                        context.calculate(Division);
                        break;
                    case "+":
                        MathExpression<Double> Plus = x -> x.push(x.poll() + x.poll());
                        context.calculate(Plus);
                        break;
                    case "-":
                        MathExpression<Double> Minus = x -> x.push(-x.poll() + x.poll());
                        context.calculate(Minus);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + element);
                }
            }
        }
        return (double) context.poll();
    }
}




