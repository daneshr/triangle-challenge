package com.tradeshift.business.matcher;

import com.tradeshift.business.Shape;

public interface Matcher<T extends Shape> {
    boolean match(T t);

    String getType();
}
