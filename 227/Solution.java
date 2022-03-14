class Solution {
    public int calculate(String s) {
        // return usingStack(s);
        return withoutStack(s);
    }
    
    public int withoutStack(String s) {
        int currentNumber = 0;
        int lastNumber = 0;
        int result = 0;
        char operator = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }
            
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1) {
                if (operator == '+') {
                    result += lastNumber;
                    lastNumber = currentNumber;
                } else if (operator == '-') {
                    result += lastNumber;
                    lastNumber = -currentNumber;
                } else if (operator == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operator == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                
                currentNumber = 0;
                operator = c;
            }
        }
        
        result += lastNumber;
        return result;
    }
    
    public int usingStack(String s) {
        int currentNumber = 0;
        char operator = '+';
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }
            
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1) {
                if (operator == '+') {
                    stack.push(currentNumber);
                } else if (operator == '-') {
                    stack.push(-currentNumber);
                } else if (operator == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operator == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                
                currentNumber = 0;
                operator = c;
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}