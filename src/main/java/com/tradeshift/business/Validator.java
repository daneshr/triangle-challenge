package com.tradeshift.business;

public interface Validator<T extends Shape> {
    void validate(T t);
}
