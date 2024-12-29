class Solution {
    private Set<String> answer;
    private int minimumRemoved;
    public List<String> removeInvalidParentheses(String s) {
        answer = new HashSet<>();
        minimumRemoved = Integer.MAX_VALUE;
        helper(s, new StringBuilder(), 0, 0, 0, 0);
        return new ArrayList<>(answer);
    }

    private void helper(String s, StringBuilder curr, int index, int leftCount, int rightCount, int removedCount) {
        //reached the end of input string
        if (index == s.length()) {
            //If current expression is valid
            if (leftCount == rightCount) {
                //If current count of removed parentheses is less than current minimum count 
                if (removedCount <= minimumRemoved) {
                    if (removedCount < minimumRemoved) {
                        //empty the current set 
                        answer.clear();
                        minimumRemoved = removedCount;
                    }
                    answer.add(curr.toString());
                }
            }
            return ;
        }

        char c = s.charAt(index);
    
        //add - recurse - remove
        //If current char is not a parentheses add it to the expression
        if (c != '(' && c != ')') {
            curr.append(c);
            helper(s, curr, index + 1, leftCount, rightCount, removedCount);
            curr.deleteCharAt(curr.length() - 1);
        } else {
            //check after removing current parentheses
            helper(s, curr, index + 1, leftCount, rightCount, removedCount + 1);

            //else add the parentheses to currString
            curr.append(c);

            //considering all opening parentheses for backtracking and only right parentheses that have a valid left parentheses
            if (c == '(') {
                helper(s, curr, index + 1, leftCount + 1, rightCount, removedCount);
            } else if (c == ')' && rightCount < leftCount) {
                helper(s, curr, index + 1, leftCount, rightCount + 1, removedCount);
            }

            //removing the last character after backtracking
            curr.deleteCharAt(curr.length() - 1);
        }

        return ;
    }
}

/*
 * 
 * T: O(2^N) - Worst case we have all left parentheses and we have two options whether to keep it or remove it so for N parentheses 2^N
 * S: O(N) - Recursive stack's max size would be N  
 */