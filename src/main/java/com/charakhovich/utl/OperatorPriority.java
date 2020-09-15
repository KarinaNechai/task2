package com.charakhovich.utl;

public enum OperatorPriority implements Comparable<OperatorPriority> {
    HIGH(4),
    MEDIUM(3),
    LOW(2);
    private int valuePriority;

    private OperatorPriority(int valuePriority) {
    }

    public int getValuePriority() {
        return valuePriority;
    }

}