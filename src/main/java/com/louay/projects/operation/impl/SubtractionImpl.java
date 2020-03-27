package com.louay.projects.operation.impl;

import com.louay.projects.operation.Subtraction;

public class SubtractionImpl extends OperationImpl implements Subtraction {

    public SubtractionImpl() {
    }

    @Override
    public Number subtractionOperation(Number num1, Number num2) {
        Number result = num1.doubleValue() - num2.doubleValue();
        super.setResult(result);
        return result;
    }

    @Override
    public String toString() {
        return super.toString()+" /Subtraction operation";
    }
}
