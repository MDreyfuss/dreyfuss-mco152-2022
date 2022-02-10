import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RPNTest {

    @Test
    public void evaluateSimple()
    {
        //given
        RPN r = new RPN();

        //when
        String result = r.evaluate("3 4 +"); //3+4

        //then
        assertEquals("7.0", result);

    }

    @Test
    public void evaluateComplex()
    {
        //given
        RPN r = new RPN();

        //when
        String result = r.evaluate("3 4 + 2 9 * -"); //3+4-2*9

        //then
        assertEquals("-11.0", result);

    }

    @Test
    public void evaluateError()
    {
        //given
        RPN r = new RPN();

        //when
        String result = r.evaluate("3 4 + 2 9 * - /"); //error

        //then
        assertEquals("Invalid syntax", result);


    }

}