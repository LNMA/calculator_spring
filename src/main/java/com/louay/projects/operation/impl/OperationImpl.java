package com.louay.projects.operation.impl;

import com.louay.projects.operation.Operation;

import java.util.Objects;

abstract public class OperationImpl implements Operation {
    private Number result;
    private Number number1;
    private Number number2;


    public Number getResult() {
        return result;
    }

    public void setResult(Number result) {
        this.result = result;
    }

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

    @Override
    public void printResult() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Operation{ " +
                "result = " + result +
                ", number1 = " + number1 +
                ", number2 = " + number2 +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationImpl)) return false;
        OperationImpl operation = (OperationImpl) o;
        return Objects.equals(getResult(), operation.getResult()) &&
                Objects.equals(getNumber1(), operation.getNumber1()) &&
                Objects.equals(getNumber2(), operation.getNumber2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResult(), getNumber1(), getNumber2());
    }
}
