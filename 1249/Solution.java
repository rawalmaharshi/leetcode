class Solution {
    public String minRemoveToMakeValid(String s) {
        // return usingStack(s);
        return usingReverse(s);
    }

    //T: O(4n) S: O(n)
    private String usingStack(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> indexToRemove = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()) {
            indexToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    //T: O(2n) S: O(n)
    private String usingReverse(String s) {
        StringBuilder result = removeInvalidClosing(s, '(', ')');
        result = removeInvalidClosing(result.reverse(), ')', '(');
        return result.reverse().toString();
    }

    private StringBuilder removeInvalidClosing(CharSequence s, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == open) {
                balance++;
            } if (c == close) {
                if (balance == 0) {
                    continue;
                }
                balance--;
            }
            sb.append(c);
        }
        return sb;
    }
}