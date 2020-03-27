package com.louay.projects.operation.impl;

import com.louay.projects.operation.Power;

public class PowerImpl extends OperationImpl implements Power {

    public PowerImpl() {
    }

    @Override
    public Number powerOperation(Number base, Number order) {
        Number result = Math.pow(base.doubleValue() , order.doubleValue());
        super.setResult(result);
        return result;
    }

    @Override
    public String toString() {
        return super.toString()+" /Power operation";
    }
}
