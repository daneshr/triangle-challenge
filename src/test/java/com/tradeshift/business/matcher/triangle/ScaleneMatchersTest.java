package com.tradeshift.business.matcher.triangle;

import com.tradeshift.business.triangle.Triangle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ScaleneMatchersTest {

    @InjectMocks
    ScaleneTriangleMatcher scaleneTriangleMatcher;

    @Test
    public void shouldReturnTrue_whenReceiveScaleneCondition() {
        Assert.assertTrue(scaleneTriangleMatcher.match(new Triangle(3, 4, 5)));
        Assert.assertTrue(scaleneTriangleMatcher.match(new Triangle(Integer.MAX_VALUE, 0, 2)));
        Assert.assertTrue(scaleneTriangleMatcher.match(new Triangle(1000, 5, -1)));
        Assert.assertTrue(scaleneTriangleMatcher.match(new Triangle(0, -1, -2)));
    }

    @Test
    public void shouldReturnFalse_whenReceiveNotScalene() {
        Assert.assertFalse(scaleneTriangleMatcher.match(new Triangle(2, 1, 1)));
        Assert.assertFalse(scaleneTriangleMatcher.match(new Triangle(1, 1, 1)));
        Assert.assertFalse(scaleneTriangleMatcher.match(new Triangle(Integer.MAX_VALUE, Integer.MAX_VALUE, 7)));
        Assert.assertFalse(scaleneTriangleMatcher.match(new Triangle(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)));
        Assert.assertFalse(scaleneTriangleMatcher.match(new Triangle(-1, -2, -2)));
        Assert.assertFalse(scaleneTriangleMatcher.match(new Triangle(0, 0, 0)));
    }
}
