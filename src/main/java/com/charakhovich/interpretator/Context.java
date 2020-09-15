package com.charakhovich.interpretator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context<T> {
    private Deque<T> stack = new ArrayDeque<>();
    public T poll() {
        return stack.poll();
    }
    public void push(T t) {
        stack.push(t);
    }
    public void calculate( MathExpression expression) {
        expression.interpret(this);
    }

}
