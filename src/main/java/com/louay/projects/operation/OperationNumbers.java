package com.louay.projects.operation;


import java.util.Objects;

public class OperationNumbers {

    private Number number1 ;
    private Number number2 ;
    private Operation operation;

    public Number getNumber1() {
        return number1;
    }

    public void setNumber1(Number number1) {
        this.number1 = number1;
    }

    public Number getNumber2() {
        return number2;
    }

    public void setNumber2(Number number2) {
        this.number2 = number2;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void printResult(){
        this.operation.printResult();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationNumbers)) return false;
        OperationNumbers that = (OperationNumbers) o;
        return Objects.equals(getNumber1(), that.getNumber1()) &&
                Objects.equals(getNumber2(), that.getNumber2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber1(), getNumber2());
    }

    @Override
    public String toString() {
        return "OperationNumbers{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                ", operation=" + operation.toString() +
                '}';
    }
}
