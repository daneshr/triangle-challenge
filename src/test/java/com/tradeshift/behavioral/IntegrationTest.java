package com.tradeshift.behavioral;

import com.tradeshift.business.matcher.triangle.EquilateralTriangleMatcher;
import com.tradeshift.business.matcher.triangle.IsoscelesTriangleMatcher;
import com.tradeshift.business.matcher.triangle.ScaleneTriangleMatcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
    @Autowired
    private MockMvc mvc;

    private String callSuccessfulTriangleService(int sideA, int sideB, int sideC) throws Exception {
        return mvc.perform(get("/shape/triangle/{sideA}/{sideB}/{sideC}", sideA, sideB, sideC))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    public void shouldReturnCorrectTypeTest() throws Exception {
        Assert.assertEquals(callSuccessfulTriangleService(2, 3, 4), ScaleneTriangleMatcher.SCALENE_TRIANGLE);
        Assert.assertEquals(callSuccessfulTriangleService(2, 2, 2), EquilateralTriangleMatcher.EQUILATERAL_TRIANGLE);
        Assert.assertEquals(callSuccessfulTriangleService(3, 3, 4), IsoscelesTriangleMatcher.ISOSCELES_TRIANGLE);
        Assert.assertEquals(callSuccessfulTriangleService(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE), EquilateralTriangleMatcher.EQUILATERAL_TRIANGLE);
        Assert.assertEquals(callSuccessfulTriangleService(Integer.MAX_VALUE, Integer.MAX_VALUE, 4), IsoscelesTriangleMatcher.ISOSCELES_TRIANGLE);
        Assert.assertNotEquals(callSuccessfulTriangleService(2, 2, 2), ScaleneTriangleMatcher.SCALENE_TRIANGLE);
        Assert.assertNotEquals(callSuccessfulTriangleService(3, 3, 4), ScaleneTriangleMatcher.SCALENE_TRIANGLE);
        Assert.assertNotEquals(callSuccessfulTriangleService(2, 2, 2), IsoscelesTriangleMatcher.ISOSCELES_TRIANGLE);
    }

    @Test
    public void shouldReturn4xxError_whenReceiveBadSides() throws Exception {
        callUnsuccessfulTriangleService(0, 0, 0);
        callUnsuccessfulTriangleService(1, 0, 0);
        callUnsuccessfulTriangleService(3, 2, 0);
        callUnsuccessfulTriangleService(-1, -2, -3);
        callUnsuccessfulTriangleService(3, 4, -4);
        callUnsuccessfulTriangleService(1, 2, 4);
        callUnsuccessfulTriangleService(3, 4, Integer.MAX_VALUE);
        callUnsuccessfulTriangleService(1, 2, 3);

    }

    private void callUnsuccessfulTriangleService(int sideA, int sideB, int sideC) throws Exception {
        mvc.perform(get("/shape/triangle/{sideA}/{sideB}/{sideC}", sideA, sideB, sideC))
                .andExpect(status().is4xxClientError());
    }
}
