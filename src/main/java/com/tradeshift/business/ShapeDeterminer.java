package com.tradeshift.business;

public abstract class ShapeDeterminer<T extends Shape> implements Validator<T> {

    public final String determine(T t) {
        validate(t);
        return findType(t);
    }

    protected abstract String findType(T t);
}
