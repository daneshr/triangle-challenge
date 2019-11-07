package com.tradeshift.business;

import com.tradeshift.business.matcher.Matcher;
import com.tradeshift.exception.exception.ShapeNotSupportedException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TypeFinderTest<T extends Shape, E extends Matcher<T>> {

    private TypeFinder typeFinderAllFalseMatcher;
    private TypeFinder typeFinderHasTrueMatcher;


    @Before
    public void setUp() {
        Matcher matcherDoesntMatch = new Matcher<T>() {
            @Override
            public boolean match(T t) {
                return false;
            }

            @Override
            public String getType() {
                return "false";
            }
        };
        Matcher matcherMatch = new Matcher<T>() {
            @Override
            public boolean match(T t) {
                return true;
            }

            @Override
            public String getType() {
                return "true";
            }
        };


        typeFinderAllFalseMatcher = new TypeFinder<T, E>() {
            @Override
            protected List<E> getMatchers() {
                List matchers = new ArrayList<E>();
                matchers.add(matcherDoesntMatch);
                matchers.add(matcherDoesntMatch);
                return matchers;
            }
        };
        typeFinderHasTrueMatcher = new TypeFinder<T, E>() {
            @Override
            protected List<E> getMatchers() {
                List matchers = new ArrayList<E>();
                matchers.add(matcherDoesntMatch);
                matchers.add(matcherMatch);
                return matchers;
            }
        };

    }

    @Test
    public void shouldReturnTrueType_whenFindSuitableMatcher() {
        Assert.assertEquals(typeFinderHasTrueMatcher.find(new Shape() {

        }), "true");
    }

    @Test(expected = ShapeNotSupportedException.class)
    public void shouldThrowShapeNotSupportedException_whenSuitableMatcherIsNotAvailable() {
        typeFinderAllFalseMatcher.find(new Shape() {
        });
    }
}
