package com.tradeshift.business.matcher.triangle;

import com.tradeshift.business.triangle.Triangle;
import org.springframework.stereotype.Repository;

@Repository
public class ScaleneTriangleMatcher implements TriangleMatcher {
    public static final String SCALENE_TRIANGLE = "Scalene Triangle";

    @Override
    public boolean match(Triangle triangle) {
        if ((triangle.getSideA() != triangle.getSideB()) && (triangle.getSideA() != triangle.getSideC()) && (triangle.getSideB() != triangle.getSideC()))
            return true;
        else
            return false;
    }

    @Override
    public String getType() {
        return SCALENE_TRIANGLE;
    }
}
