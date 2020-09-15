package com.charakhovich.interpretator;

public class NonTerminalOperation<T> implements MathExpression {
    private T element;

    public NonTerminalOperation(T element) {
        this.element = element;
    }

    @Override
    public void interpret(Context t) {
        t.push(element);
    }

}
