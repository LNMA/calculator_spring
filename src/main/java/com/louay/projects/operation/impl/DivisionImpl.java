package com.louay.projects.operation.impl;

import com.louay.projects.operation.Division;

public class DivisionImpl extends OperationImpl implements Division {

    public DivisionImpl() {
    }

    @Override
    public Number divisionOperation(Number numerator, Number denominator) {
        Number result = numerator.doubleValue() / denominator.doubleValue();
        super.setResult(result);
        return result;
    }

    @Override
    public String toString() {
        return super.toString()+" /Division operation";
    }
}
