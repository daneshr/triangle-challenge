package com.tradeshift.business.matcher.triangle;

import com.tradeshift.business.triangle.Triangle;
import org.springframework.stereotype.Repository;

@Repository
public class EquilateralTriangleMatcher implements TriangleMatcher {

    public static final String EQUILATERAL_TRIANGLE = "Equilateral Triangle";

    @Override
    public boolean match(Triangle triangle) {
        if ((triangle.getSideA() == triangle.getSideB()) && (triangle.getSideA() == triangle.getSideC()))
            return true;
        else
            return false;
    }

    @Override
    public String getType() {
        return EQUILATERAL_TRIANGLE;
    }
}
