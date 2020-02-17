/*
Name: Abigail Natucci
Assignment: Lab06
Sources consulted: n/a
Known Bugs: n/a
*/
import java.util.Stack;

public class InfixEvaluator {
    /**
     * Evaluates an infix expression and returns the result of the expression
     * @param expression an infix expression where each term is separated by at least one space.
     * @return the result of the expression.
     */
    public static int evaluate( String expression ){
        Stack<String> operator = new Stack<String>();
        Stack<Integer> operands = new Stack<Integer>();

        String[] exp = expression.split("\\s+");
        for(int i = 0; i<exp.length; i++){
            if(exp[i].matches("[0-9]+")){
                operands.push(Integer.parseInt(exp[i]));
            }
            else if(exp[i].equals("(")){
                operator.push(exp[i]);
            }
            else if(exp[i].equals(")")){
                while(!operator.peek().equals("(")){
                    operands.push(performOperation(operands.pop(), operands.pop(), operator.pop()));
                }
                operator.pop();
            }
            else if(isOperator(exp[i])) {
                while (!operator.empty() && hasPrecedence(exp[i], operator.peek()) && operands.size() > 1) {
                    operands.push(performOperation(operands.pop(), operands.pop(), operator.pop()));
                }
                operator.push(exp[i]);
            }
            else{
                throw new SyntaxErrorException("Invalid character found in expression");
                }
        }
        while(!operator.empty() && operands.size() > 1)
        {
            operands.push(performOperation(operands.pop(),operands.pop(),operator.pop()));
        }

        //System.out.println("\nOriginal Expression: " + expression);
        //System.out.println("Final Result:  " + operands.peek());
        return operands.pop();
    }

    private static boolean hasPrecedence(String val, String peek) {
        if(val.equals("(") || val.equals(")"))
            return false;
        else{
            return !(val.equals("^") || (val.equals("*") || val.equals("/") || val.equals("%")) && (peek.equals("+") || peek.equals("-")));
        }
    }

    private static boolean isOperator(String value) {
        return value.equals("+") || value.equals("-")|| value.equals("*") || value.equals("/") || value.equals("^");
    }

    private static Integer performOperation(Integer a, Integer b, String op) {
        switch(op) {
            case "+":
                return a + b;
            case "-":
                return Math.abs(a - b);
            case "*":
                return a * b;
            case "/":
                if(a != 0) {
                    return b / a;
                }
                else {
                    throw new ArithmeticException("Cannot Divide by Zero");
                }
            case "^":
                return (int) Math.pow(b, a);
        }
        return -1;
    }

}
