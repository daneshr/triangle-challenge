package com.tradeshift.service;


import com.tradeshift.business.triangle.Triangle;
import com.tradeshift.business.triangle.TriangleDeterminer;
import com.tradeshift.exception.exception.ShapeNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriangleServiceImpl implements TriangleService {

    @Autowired
    TriangleDeterminer triangleDeterminer;

    /**
     * get the type of the given triangle
     *
     * @return triangle type
     * @throws IllegalArgumentException
     * @throws ShapeNotSupportedException
     */
    @Override
    public String getType(int sideA, int sideB, int sideC) {
        return triangleDeterminer.determine(new Triangle(sideA, sideB, sideC));
    }
}
