package com.tradeshift.business.triangle;

import com.tradeshift.business.ShapeDeterminer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriangleDeterminer extends ShapeDeterminer<Triangle> {

    @Autowired
    TriangleValidator validator;

    @Autowired
    TriangleTypeFinder typeFinder;

    @Override
    protected String findType(Triangle triangle) {
        return typeFinder.find(triangle);
    }

    @Override
    public void validate(Triangle triangle) {
        validator.validate(triangle);
    }
}
