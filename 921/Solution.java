class Solution {
    public int minAddToMakeValid(String s) {
        return usingBalance(s);
        // return usingStack(s);
    }
    
    public int usingStack(String s) {
        //Algo: On '(' add to stack, On ')' see if the top element is '(', if it is remove otherwise add
        //final answer is stack size
        
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(')');
                }
            }
        }
        
        return stack.size();
    }
    
    public int usingBalance(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }
}