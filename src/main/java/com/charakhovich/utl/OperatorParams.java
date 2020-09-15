package com.charakhovich.utl;

public class OperatorParams {
    private OperatorPriority priority;
    private OperatorAssociativity associativity;

    public OperatorParams(OperatorPriority priority,OperatorAssociativity associativity) {
        this.associativity = associativity;
        this.priority = priority;
    }

    public OperatorAssociativity getAssociativity() {
        return associativity;
    }

    public void setAssociativity(OperatorAssociativity associativity) {
        this.associativity = associativity;
    }

    public OperatorPriority getPriority() {
        return priority;
    }

    public void setPriority(OperatorPriority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperatorParams that = (OperatorParams) o;
        return getAssociativity() == that.getAssociativity() &&
                getPriority() == that.getPriority();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime + associativity.hashCode();
        result = result * prime + priority.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder strResult = new StringBuilder("OperatorParams");
        strResult.append("{ associativity=").append(associativity).append(';');
        strResult.append(" priority=").append(priority).append('}');
        return strResult.toString();
    }
}
