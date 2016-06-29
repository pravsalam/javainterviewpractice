/**
 * Created by praveenkumaralam on 8/5/15.
 */
public class Parantheses {
    public static void main(String[] args){
        String calculation = "2*3-4+5";
        //(2)*(3-4+5)
        //(2*3) -4+5
        //2*(3-4)+5
        //(2*3) - (4+5)

    }
    private int[] possibleComputations(String equation){

        compute(equation,0);
        return new int[0];
    }
    private int[] compute(String equation, int low){
        // consider a*B(Op)someEquation. it can be done as a*(B(OP)Eq) or (a*B) Op (Eq).
        // The first term is dedicated for the operator * and second is a integer array

        char centralOperator='+';
        int operatorLoc =0;
        int leftOperand;
        int rightOperand;
        char rightOperator;
        int rightOperatorLoc =0;
        int[] result;
        //terminating condition. There is one digit, thats it
        if(isNumerical(equation)){
            int digit = Integer.parseInt(equation);
            return new int[]{digit};
        }else{
            // this was not an integer. Its a proper equations.
            // operator binding to right digit, take care of the operator next to the right digit
            // operator not binding to right digit, no need to

            //get first number
            for(int i=low;i<equation.length();i++){
                if(!Character.isDigit(equation.charAt(i))){
                    //found the operator. what ever to the left was a digit
                    centralOperator = equation.charAt(i);
                    operatorLoc = i;
                }
            }
            StringBuilder strBuilder = new StringBuilder();
            for(int j=low;j<operatorLoc;j++){
                strBuilder.append(equation.charAt(j));
            }
            leftOperand = Integer.parseInt(strBuilder.toString());
            StringBuilder rightOperandBuilder = new StringBuilder();
            for(int i = operatorLoc+1;i<equation.length();i++){
                if(Character.isDigit(equation.charAt(i))){
                    rightOperandBuilder.append(equation.charAt(i));
                }
                else{
                    rightOperator = equation.charAt(equation.charAt(i));
                    rightOperatorLoc = i;
                    break;
                }
            }
            rightOperand = Integer.parseInt(rightOperandBuilder.toString());

            //high affinity
            int highAffinInterimResult = 0;
            highAffinInterimResult = performOperation(leftOperand, centralOperator, rightOperand);
            int[] resultsFromLeftString = compute(equation, rightOperatorLoc+1);
            for(int i=0;i<resultsFromLeftString.length;i++){

            }



            //low affinity

        }
        return new int[0];
    }
    private boolean isNumerical(String eq){
        int numericalValue;
        try{
            numericalValue = Integer.parseInt(eq);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    private int performOperation(int leftOperand, char operator, int rightOperand){
        int result;
        switch(operator) {
            case '+':
                result = leftOperand + rightOperand;
                break;
            case '-':
                result = leftOperand - rightOperand;
                break;
            case '*':
                result = leftOperand * rightOperand;
                break;
            case '/':
                result = leftOperand / rightOperand;
                break;
            default:
                result =0;
        }
        return result;
    }
}
