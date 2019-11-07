package com.tradeshift.business;

import com.tradeshift.business.matcher.Matcher;
import com.tradeshift.exception.exception.ShapeNotSupportedException;

import java.util.List;

public abstract class TypeFinder<T extends Shape, E extends Matcher<T>> {

    protected abstract List<E> getMatchers();

    public final String find(T t) {
        return getMatchers()
                .stream()
                .filter(matcher -> matcher.match(t))
                .findFirst()
                .orElseThrow(() -> new ShapeNotSupportedException("not supported type."))
                .getType();
    }
}
