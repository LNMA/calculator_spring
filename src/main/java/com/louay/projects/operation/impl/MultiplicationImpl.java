package com.louay.projects.operation.impl;

import com.louay.projects.operation.Multiplication;

public class MultiplicationImpl extends OperationImpl implements Multiplication {

    public MultiplicationImpl() {
    }

    @Override
    public Number multiplicationOperation(Number num1, Number num2) {
        Number result = num1.doubleValue() * num2.doubleValue();
        super.setResult(result);
        return result;
    }

    @Override
    public String toString() {
        return super.toString()+" /Multiplication operation";
    }
}
