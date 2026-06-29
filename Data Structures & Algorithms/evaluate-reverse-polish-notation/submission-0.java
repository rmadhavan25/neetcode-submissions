class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        int firstOperand = 0;
        int secondOperand = 0;

        for(int i = 0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-")  || tokens[i].equals("/")  || tokens[i].equals("*")  ){
                secondOperand = stack.pop();
                firstOperand = stack.pop();
                if(tokens[i].equals("+") )
                    stack.push(firstOperand + secondOperand);
                else if(tokens[i].equals("/"))
                    stack.push(firstOperand / secondOperand);
                else if(tokens[i].equals("*") )
                    stack.push(firstOperand * secondOperand);
                else
                    stack.push(firstOperand - secondOperand);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
        
    }
}
