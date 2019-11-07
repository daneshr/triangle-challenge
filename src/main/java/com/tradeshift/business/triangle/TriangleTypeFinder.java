package com.tradeshift.business.triangle;

import com.tradeshift.business.TypeFinder;
import com.tradeshift.business.matcher.triangle.TriangleMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TriangleTypeFinder extends TypeFinder<Triangle, TriangleMatcher> {

    @Autowired
    private List<TriangleMatcher> triangleMatchers;

    @Autowired
    private PreferredTriangleMatcherContainer preferredTriangleMatcherContainer;

    @Override
    protected List<TriangleMatcher> getMatchers() {
        return Objects.nonNull(preferredTriangleMatcherContainer)
                ? preferredTriangleMatcherContainer.getTriangleMatchers()
                : triangleMatchers;
    }

}
