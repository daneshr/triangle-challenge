package com.tradeshift.business.triangle;

import com.tradeshift.business.Shape;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Triangle implements Shape {
    private int sideA;
    private int sideB;
    private int sideC;
}
