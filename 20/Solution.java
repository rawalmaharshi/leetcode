class Solution {
    public boolean isValid(String s) {
        //edge case
        if (s.length() % 2 == 1) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ((c == '(') || (c == '[') || (c == '{')) {
                stack.push(c);
            } else {
                if (stack.size() == 0) return false;
                
                char top = stack.pop();
                if ((c == ')') && (top != '(')) {
                    return false;
                } else if ((c == ']') && (top != '[')) {
                    return false;
                } else if ((c == '}') && (top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.size() == 0;
    }
}