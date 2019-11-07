package com.tradeshift.behavioral;

import com.tradeshift.business.matcher.triangle.EquilateralTriangleMatcher;
import com.tradeshift.business.matcher.triangle.IsoscelesTriangleMatcher;
import com.tradeshift.business.matcher.triangle.ScaleneTriangleMatcher;
import com.tradeshift.service.TriangleServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TriangleServiceTest {

    @Autowired
    private TriangleServiceImpl triangleService;

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_whenReceiveNegativeSide() {
        triangleService.getType(1, -4, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_whenReceiveZeroSide() {
        triangleService.getType(0, 4, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_twoSidesSumIsSmallerThanTheOther() {
        triangleService.getType(5, 3, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_twoSidesSumIsEqualToOther() {
        triangleService.getType(1, 3, 2);
    }

    @Test
    public void shouldReturnIsosceles_whenOnlyTwoSidesAreEqual() {
        Assert.assertEquals(triangleService.getType(3, 3, 1), IsoscelesTriangleMatcher.ISOSCELES_TRIANGLE);
    }

    @Test
    public void shouldNotReturnIsosceles_whenThreeSidesAreEqual() {
        Assert.assertNotEquals(triangleService.getType(3, 3, 3), IsoscelesTriangleMatcher.ISOSCELES_TRIANGLE);
    }

    @Test
    public void shouldReturnEquilateral_whenThreeSidesAreEqual() {
        Assert.assertEquals(triangleService.getType(3, 3, 3), EquilateralTriangleMatcher.EQUILATERAL_TRIANGLE);
    }

    @Test
    public void shouldReturnScalene_whenThreeSidesAreDifferent() {
        Assert.assertEquals(triangleService.getType(3, 4, 5), ScaleneTriangleMatcher.SCALENE_TRIANGLE);
    }

    @Test
    public void shouldNotReturnScalene_whenTwoSidesAreEqual() {
        Assert.assertNotEquals(triangleService.getType(3, 3, 1), ScaleneTriangleMatcher.SCALENE_TRIANGLE);
    }

    @Test
    public void shouldNotReturnScalene_whenThreeSidesAreEqual() {
        Assert.assertNotEquals(triangleService.getType(3, 3, 3), ScaleneTriangleMatcher.SCALENE_TRIANGLE);
    }
}
