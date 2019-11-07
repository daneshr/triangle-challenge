package com.tradeshift.business.triangle;


import org.junit.Assert;
import org.junit.Test;

/**
 * Test of triangle validate method
 */
public class TriangleValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_whenReceiveNegativeSideA() {
        new TriangleValidator().validate(new Triangle(-1, 4, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_whenReceiveNegativeSideB() {
        new TriangleValidator().validate(new Triangle(1, -4, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_whenReceiveNegativeSideC() {
        new TriangleValidator().validate(new Triangle(5, 5, -5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_whenReceiveAllSidesNegative() {
        new TriangleValidator().validate(new Triangle(-3, -4, -5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_whenReceiveZeroSideA() {
        new TriangleValidator().validate(new Triangle(0, 4, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_whenReceiveZeroSideB() {
        new TriangleValidator().validate(new Triangle(4, 0, 8));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_whenReceiveZeroSideC() {
        new TriangleValidator().validate(new Triangle(3, 4, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_whenReceiveSomeZeroSides() {
        new TriangleValidator().validate(new Triangle(0, 4, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_whenReceiveAllSidesZero() {
        new TriangleValidator().validate(new Triangle(0, 0, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_twoSidesSumIsSmallerThanTheOther() {
        new TriangleValidator().validate(new Triangle(5, 3, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_twoSidesSumIsSmallerThanTheOtherMaxInteger() {
        new TriangleValidator().validate(new Triangle(5, 3, Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_twoSidesSumIsEqualToOther() {
        new TriangleValidator().validate(new Triangle(1, 3, 2));
    }

    @Test
    public void normalTriangleTest() {
        Triangle t1 = new Triangle(3, 4, 5);
        new TriangleValidator().validate(t1);
        Assert.assertEquals(t1.getSideA(), 3);
        Assert.assertEquals(t1.getSideB(), 4);
        Assert.assertEquals(t1.getSideC(), 5);

        t1 = new Triangle(1, Integer.MAX_VALUE, Integer.MAX_VALUE);
        new TriangleValidator().validate(t1);
        Assert.assertEquals(t1.getSideA(), 1);
        Assert.assertEquals(t1.getSideB(), Integer.MAX_VALUE);
        Assert.assertEquals(t1.getSideC(), Integer.MAX_VALUE);

        t1 = new Triangle(1, 1, 1);
        new TriangleValidator().validate(t1);
        Assert.assertEquals(t1.getSideA(), 1);
        Assert.assertEquals(t1.getSideB(), 1);
        Assert.assertEquals(t1.getSideC(), 1);
    }
}
