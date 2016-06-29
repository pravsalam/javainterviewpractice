import java.util.Stack;

/**
 * Created by praveenkumaralam on 10/31/15.
 */
public class InfixToPostfix {
    public static void main(String[] args){
        String exp = "(((1+2)+(3/5))*(3+4))";
        //convert it to postfix 12+3*5+
        //convert it to prefix +*+1235
        //A*B+C/D  ---> +*AB/CD
        String postfix = convertInfix2Postfix(exp);
        String prefix = convertInfix2Prefix(exp);
        System.out.println(postfix);
        System.out.println(prefix);
    }
    static String convertInfix2Postfix(String infix){
        Stack<Character> stack = new Stack<Character>();
        int len = infix.length();
        int i;
        String postfix="";
        char operator;
        for(i=0;i<len;i++){
            if(infix.charAt(i) == '+' ||
                    infix.charAt(i) == '*'||
                    infix.charAt(i) == '/'||
                    infix.charAt(i) == '-'){
                stack.push(infix.charAt(i));
                //System.out.println(" isletter = "+infix.charAt(i));

            }
            else if(infix.charAt(i) == '(') continue;
            else if(infix.charAt(i) == ')'){
                operator = stack.pop();
                System.out.println("Symbol = "+operator);
                postfix+=operator;
            }
            else{
                postfix +=infix.charAt(i);
                //some kind of symbol

            }

        }
        return postfix;
    }
    static String convertInfix2Prefix(String infix){
        int len = infix.length();
        int i;
        String prefix = "";
        Character oprnd1;
        Character oprnd2;
        Stack<String> operandStack = new Stack<String>();
        Stack<Character> operatorStack = new Stack<Character>();
        for(i=0;i<len;i++){
            if(infix.charAt(i) == '+' ||
                    infix.charAt(i) == '-'||
                    infix.charAt(i) == '/'||
                    infix.charAt(i) == '*'){
                operatorStack.push(infix.charAt(i));

            }
            else if(infix.charAt(i) == '(') continue;
            else if(infix.charAt(i) == ')'){
                Character operator = operatorStack.pop();
                String op1 = operandStack.pop();
                String op2 = operandStack.pop();
                String newOperand = operator+op2+op1;
                operandStack.push(newOperand);
            }
            else{
                operandStack.push(Character.toString(infix.charAt(i)));
            }
        }
        return operandStack.pop();
    }
}
