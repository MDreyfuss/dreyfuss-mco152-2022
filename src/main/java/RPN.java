/**
 * LCW MCON 264
 * Evaluates an RPN expression
 * by: Miriam Dreyfuss
 */

import java.util.Stack;

public class RPN
{
    public String evaluate(String expression)
    {
        String[] values = expression.split(" ");
        Stack<Double> stack = new Stack<>();
        for (String character: values)
        {
            try
            {
                stack.push(Double.parseDouble(character));
            }
            catch (NumberFormatException notInt)
            {
                if (stack.isEmpty())
                {
                    return ("Invalid syntax");
                }
                else
                {
                    double value2 = stack.pop();
                    if (stack.isEmpty())
                    {
                        return ("Invalid syntax");
                    }
                    double value1 = stack.pop();
                    if (character.equals("/")) {
                        stack.push(value1 / value2);
                    } else if (character.equals("*")) {
                        stack.push(value1 * value2);
                    } else if (character.equals("-")) {
                        stack.push(value1 - value2);
                    } else if (character.equals("+")) {
                        stack.push(value1 + value2);
                    } else {
                        stack.empty();
                        return ("Invalid syntax");
                    }
                }
            }
        }
        Double result = stack.pop();
        if (!stack.isEmpty())
        {
            stack.empty();
            return (result + "\n Extra junk ignored");
        }
        return ("" + result);
    }
}