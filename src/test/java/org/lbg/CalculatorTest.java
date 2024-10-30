package org.lbg;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void add_add_multiply_divide()
    {
        //arrange
        double x = 1.5;
        Calculator cut = new Calculator();
        double expectedResult = 3.0;

        //act
        cut.add(x);
        cut.add(x);
        cut.multiply(x);
        cut.divide(x);
        double actualResult = cut.getInitVal();





    }
}
