package com.tradeshift.business.matcher.triangle;

import com.tradeshift.business.triangle.Triangle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IsoscelesMatchersTest {

    @InjectMocks
    IsoscelesTriangleMatcher isoscelesTriangleMatcher;

    @Test
    public void shouldReturnTrue_whenReceiveIsoscelesCondition() {
        Assert.assertTrue(isoscelesTriangleMatcher.match(new Triangle(3, 1, 1)));
        Assert.assertTrue(isoscelesTriangleMatcher.match(new Triangle(Integer.MAX_VALUE, 1, Integer.MAX_VALUE)));
        Assert.assertTrue(isoscelesTriangleMatcher.match(new Triangle(7, 0, 0)));
    }

    @Test
    public void shouldReturnFalse_whenReceiveNotIsosceles() {
        Assert.assertFalse(isoscelesTriangleMatcher.match(new Triangle(1, 1, 1)));
        Assert.assertFalse(isoscelesTriangleMatcher.match(new Triangle(Integer.MAX_VALUE, 6, 7)));
        Assert.assertFalse(isoscelesTriangleMatcher.match(new Triangle(4, 3, 2)));
        Assert.assertFalse(isoscelesTriangleMatcher.match(new Triangle(-1, -2, 1000)));
        Assert.assertFalse(isoscelesTriangleMatcher.match(new Triangle(0, 5, 1)));
    }
}
