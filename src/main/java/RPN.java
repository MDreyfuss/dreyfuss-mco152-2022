/**
 * LCW MCON 264
 * Evaluates an RPN expression
 * by: Miriam Dreyfuss
 **/

import java.util.Stack;

public class RPN
{
    static final String INVALID = "Invalid Syntax";
    public String evaluate(String expression)
    {
        String[] values = expression.split(" ");
        Stack<Double> stack = new Stack<>();
        for (String character: values)
        {
         double value1, value2;
                switch (character)
                {
                    case "+":
                        if (stackLow(stack))
                        {
                            return INVALID;
                        }
                        value2 = stack.pop();
                        value1 = stack.pop();
                        stack.push(value1 + value2);
                        break;
                    case "-":
                        if (stackLow(stack))
                        {
                            return INVALID;
                        }
                        value2 = stack.pop();
                        value1 = stack.pop();
                        stack.push(value1 - value2);
                        break;
                    case "*":
                        if (stackLow(stack))
                        {
                            return INVALID;
                        }
                        value2 = stack.pop();
                        value1 = stack.pop();
                        stack.push(value1 * value2);
                        break;
                    case "/":
                        if (stackLow(stack))
                        {
                            return INVALID;
                        }
                        value2 = stack.pop();
                        value1 = stack.pop();
                        stack.push(value1 / value2);
                        break;
                    default:
                        try
                        {
                            stack.push(Double.parseDouble(character));
                        }
                        catch (NumberFormatException notInt)
                        {
                            stack.empty();
                            return INVALID;
                        }
                    }
                }
        Double result = stack.pop();
        if (!stack.isEmpty())
        {
            stack.empty();
            return result + "\nExtra junk ignored";
        }
        return result.toString();
    }

    public boolean stackLow (Stack stack)
    {
        if (stack.size() >= 2)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}