package com.tradeshift.business.matcher.triangle;

import com.tradeshift.business.triangle.Triangle;
import org.springframework.stereotype.Repository;

@Repository
public class IsoscelesTriangleMatcher implements TriangleMatcher {
    public static final String ISOSCELES_TRIANGLE = "Isosceles Triangle";

    @Override
    public boolean match(Triangle triangle) {
        if (((triangle.getSideA() == triangle.getSideB()) && (triangle.getSideA() != triangle.getSideC())) ||
                ((triangle.getSideA() == triangle.getSideC()) && (triangle.getSideA() != triangle.getSideB())) ||
                ((triangle.getSideB() == triangle.getSideC()) && (triangle.getSideB() != triangle.getSideA())))
            return true;
        else
            return false;
    }

    @Override
    public String getType() {
        return ISOSCELES_TRIANGLE;
    }
}
