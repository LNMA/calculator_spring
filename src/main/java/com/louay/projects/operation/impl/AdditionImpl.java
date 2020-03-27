package com.louay.projects.operation.impl;

import com.louay.projects.operation.Addition;


public class AdditionImpl extends OperationImpl implements Addition  {

    public AdditionImpl() {
    }

    @Override
    public Number additionOperation(Number num1, Number num2) {
        Number result = num1.doubleValue() + num2.doubleValue();
        setResult(result);
        return result;
    }

    @Override
    public String toString() {
        return super.toString()+" /Addition operation";
    }
}
