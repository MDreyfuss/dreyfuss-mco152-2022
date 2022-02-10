import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {

    @Test
    public void getXSimple()
    {
        //given
        QuadraticEquation q = new QuadraticEquation(1, 8, 7);

        //when
        double[] x = q.getX(); //-1 & -7

        //then
        assertArrayEquals(new double[]{-1.0, -7.0}, x, .0001);
    }

    @Test
    public void getXNaN()
    {
        //given
        QuadraticEquation q = new QuadraticEquation(1, 2, 7);

        //when
        double[] x = q.getX();

        //then
        assertArrayEquals(new double[]{ Double.NaN, Double.NaN}, x);

    }

    @Test
    public void getXDivideByZero()
    {
        //given
        QuadraticEquation q = new QuadraticEquation(0, 8, 7);

        //when
        double[] x = q.getX();

        //then
        assertArrayEquals(new double[]{Double.NaN, Double.NEGATIVE_INFINITY}, x);
    }
}