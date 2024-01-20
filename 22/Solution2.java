class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrackingHelper(n, 0, 0, new StringBuilder());
        return answer;
    }

    private void backtrackingHelper(int n, int openCount, int closeCount, StringBuilder sb) {
        //end case
        if (sb.length() == 2*n ) {    //opening + closing braces = 2*n
            answer.add(new String(sb));
            return ;
        }

        //can add more opening parentheses
        if (openCount < n) {
            //add
            sb.append("(");

            //recurse
            backtrackingHelper(n, openCount + 1, closeCount, sb);

            //remove
            sb.deleteCharAt(sb.length() - 1);
        }

        //add more closing parentheses
        if (closeCount < openCount) {
            //add
            sb.append(")");

            //recurse
            backtrackingHelper(n, openCount, closeCount + 1, sb);

            //remove
            sb.deleteCharAt(sb.length() - 1);
        }

        return ;
    }
}