class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String token : tokens) {
            if(isOperator(token)) {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = 0;
                if(token.equals("+")) {
                    result = num1 + num2;
                }
                if(token.equals("-")) {
                    result = num1 - num2;
                }
                if(token.equals("*")) {
                    result = num1 * num2;
                }
                if(token.equals("/")) {
                    result = num1 / num2;
                }
                stack.push(Integer.toString(result));
            }else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.peek());
    }
    private boolean isOperator(String ch) {
        if(ch.equals("+") || ch.equals("-") ||ch.equals("*") ||ch.equals("/")) {
            return true;
        }
        return false;
    }
}