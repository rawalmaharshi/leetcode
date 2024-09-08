class Solution1 {
    public String longestPalindrome(String s) {
        // return bruteForce(s);
        return dp(s);
    }

    private String dp(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    private String bruteForce(String s) {
        //edge case
        if (s == null) {
            return s;
        }

        String answer = new String();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String curr = s.substring(i, j);
                if (isPalindrome(curr)) {
                    if (curr.length() > answer.length()) {
                        answer = curr;
                    }
                }
            }
        }

        return answer;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}