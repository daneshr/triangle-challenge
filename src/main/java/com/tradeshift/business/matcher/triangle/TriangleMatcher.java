package com.tradeshift.business.matcher.triangle;

import com.tradeshift.business.matcher.Matcher;
import com.tradeshift.business.triangle.Triangle;

public interface TriangleMatcher extends Matcher<Triangle> {

    boolean match(Triangle triangle);

}
