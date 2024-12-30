class Solution {
    public boolean isMatch(String s, String p) {
        // return usingRecursion(s, p);
        // return usingMemo(s, p, 0, 0, new Boolean[s.length() + 1][p.length() + 1]);
        return usingDP(s, p);
    }

    //T: O((s + p).2^(s + p))
    //S: O(s^2 + p^2)
    private boolean usingRecursion(String s, String p) {
        //base case
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        //check if first character matches
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        // char '*' can be replaced as many times
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (
                usingRecursion(s, p.substring(2)) || 
                (first_match && usingRecursion(s.substring(1), p))
                );
        } else {
            return (
                first_match && usingRecursion(s.substring(1), p.substring(1))
            );
        }
    }

    //T: O(sp)
    //S: O(sp)
    private boolean usingMemo(String s, String p, int i, int j, Boolean memo[][]) {
        if (memo[i][j] != null) {
            return memo[i][j] == true;
        }

        Boolean answer;
        if (j == p.length()) {
            answer = i == s.length();
        } else {
            boolean first_match = 
            (i < s.length() && (p.charAt(j) == s.charAt(i) ||
            p.charAt(j) == '.')) ;

            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                answer = (
                    usingMemo(s, p, i, j + 2, memo) || 
                    (first_match && usingMemo(s, p, i + 1, j, memo))
                );
            } else {
                answer = first_match && usingMemo(s, p, i + 1, j + 1, memo);
            }
        }

        memo[i][j] = answer ? true : false;
        return answer;
    }

    //T: O(sp)
    //S: O(sp)
    private boolean usingDP(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean first_match = 
                    i < s.length() &&
                    (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');

                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (first_match && dp[i + 1][j]);
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}