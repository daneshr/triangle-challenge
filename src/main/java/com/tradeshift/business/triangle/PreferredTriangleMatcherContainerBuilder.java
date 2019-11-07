package com.tradeshift.business.triangle;

import com.tradeshift.business.matcher.triangle.TriangleMatcher;

import java.util.ArrayList;
import java.util.List;

public class PreferredTriangleMatcherContainerBuilder {
    List<TriangleMatcher> triangleMatchers = new ArrayList<>();

    public PreferredTriangleMatcherContainerBuilder add(TriangleMatcher triangleMatcher) {
        triangleMatchers.add(triangleMatcher);
        return this;
    }

    public PreferredTriangleMatcherContainer build() {
        PreferredTriangleMatcherContainer preferredTriangleMatcherContainer = new PreferredTriangleMatcherContainer();
        preferredTriangleMatcherContainer.setTriangleMatchers(triangleMatchers);
        return preferredTriangleMatcherContainer;
    }
}
