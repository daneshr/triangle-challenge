package com.tradeshift.business.triangle;

import com.tradeshift.business.Validator;
import org.springframework.stereotype.Service;

@Service
public class TriangleValidator implements Validator<Triangle> {

    @Override
    public void validate(Triangle triangle) {
        if (triangle.getSideA() <= 0 || triangle.getSideB() <= 0 || triangle.getSideC() <= 0) {
            throw new IllegalArgumentException("Triangle can't have zero or negative side");
        }
        if (triangle.getSideA() <= Math.abs(triangle.getSideB() - triangle.getSideC())
                || triangle.getSideB() <= Math.abs(triangle.getSideA() - triangle.getSideC())
                || triangle.getSideC() <= Math.abs(triangle.getSideA() - triangle.getSideB())) {
            throw new IllegalArgumentException("these sides can't build a triangle");
        }
    }
}
