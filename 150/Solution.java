class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperand(token)) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                int res = 0;
                switch(token) {
                    case "+": res = val2 + val1;
                             break;
                    case "-": res = val2 - val1;
                             break;
                    case "*": res = val2 * val1;
                             break;
                    case "/": res = val2 / val1;
                            break;
                    default:
                        throw new ArithmeticException();
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.peek();
    }
    
    private boolean isOperand(String s) {
        if (s.length() == 1 && (s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '*' || s.charAt(0) == '/')) {
            return true;
        }
        
        return false;
    }
}