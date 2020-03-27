package com.louay.projects.operation.impl;

import com.louay.projects.operation.Modulo;

public class ModuloImpl extends OperationImpl implements Modulo {

    public ModuloImpl() {
    }

    @Override
    public Number moduloOperation(Number numerator, Number denominator) {
        Number result = numerator.doubleValue() % denominator.doubleValue();
        super.setResult(result);
        return result;
    }

    @Override
    public String toString() {
        return super.toString()+" /Modulo operation";
    }
}
