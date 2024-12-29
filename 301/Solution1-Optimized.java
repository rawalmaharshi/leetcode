class Solution {
    private Set<String> answer;
    public List<String> removeInvalidParentheses(String s) {
        answer = new HashSet<>();
        
        //Find number of misplaced left and right parentheses
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                //increment right only if we don't have a matching left
                right = left == 0 ? right + 1 : right;

                //decrement left because we have found its matching right
                left = left > 0 ? left - 1 : left;
            }
        }
        helper(s, new StringBuilder(), 0, 0, 0, left, right);
        return new ArrayList<>(answer);
    }

    private void helper(String s, StringBuilder curr, int index, int leftCount, int rightCount, int leftRem, int rightRem) {
        //reached the end of input string
        if (index == s.length()) {
            //if number of remaining left and right parentheses is zero
            if (leftRem == 0 && rightRem == 0) {
                answer.add(curr.toString());
            }
            return ;
        }

        char c = s.charAt(index);

        //remove currrent parentheses - we continue recursion only if left and right remaining counts are greater than 0
        if (c == '(' && leftRem > 0) {
            helper(s, curr, index + 1, leftCount, rightCount, leftRem - 1, rightRem);
        } else if (c == ')' && rightRem > 0) {
            helper(s, curr, index + 1, leftCount, rightCount, leftRem, rightRem - 1);
        }
    
        //If current char is not a parentheses add it to the expression
        if (c != '(' && c != ')') {
            curr.append(c);
            helper(s, curr, index + 1, leftCount, rightCount, leftRem, rightRem);
            curr.deleteCharAt(curr.length() - 1);
        } else {
            //else add the parentheses to currString
            curr.append(c);

            //considering all opening parentheses for backtracking and only right parentheses that have a valid left parentheses
            if (c == '(') {
                helper(s, curr, index + 1, leftCount + 1, rightCount, leftRem, rightRem);
            } else if (c == ')' && rightCount < leftCount) {
                helper(s, curr, index + 1, leftCount, rightCount + 1, leftRem, rightRem);
            }

            //removing the last character after backtracking
            curr.deleteCharAt(curr.length() - 1);
        }

        return ;
    }
}