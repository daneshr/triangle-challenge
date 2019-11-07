package com.tradeshift.business.triangle;

import com.tradeshift.business.matcher.triangle.TriangleMatcher;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PreferredTriangleMatcherContainer {
    List<TriangleMatcher> triangleMatchers;
}
