package com.tradeshift.business.matcher.triangle;

import com.tradeshift.business.triangle.Triangle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EquilateralMatchersTest {

    @InjectMocks
    EquilateralTriangleMatcher equilateralTriangleMatcher;

    @Test
    public void shouldReturnTrue_whenReceiveEquilateralCondition() {
        Assert.assertTrue(equilateralTriangleMatcher.match(new Triangle(1, 1, 1)));
        Assert.assertTrue(equilateralTriangleMatcher.match(new Triangle(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)));
        Assert.assertTrue(equilateralTriangleMatcher.match(new Triangle(1000, 1000, 1000)));
        Assert.assertTrue(equilateralTriangleMatcher.match(new Triangle(0, 0, 0)));
    }

    @Test
    public void shouldReturnFalse_whenReceiveNotEquilateral() {
        Assert.assertFalse(equilateralTriangleMatcher.match(new Triangle(2, 1, 1)));
        Assert.assertFalse(equilateralTriangleMatcher.match(new Triangle(Integer.MAX_VALUE, Integer.MAX_VALUE, 7)));
        Assert.assertFalse(equilateralTriangleMatcher.match(new Triangle(Integer.MAX_VALUE, 0, Integer.MAX_VALUE)));
        Assert.assertFalse(equilateralTriangleMatcher.match(new Triangle(-1, -2, 1000)));
        Assert.assertFalse(equilateralTriangleMatcher.match(new Triangle(0, 3, 1)));
    }
}
