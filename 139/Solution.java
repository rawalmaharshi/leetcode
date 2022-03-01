class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> set = new HashSet<>();
//         for (String word : wordDict) {
//             set.add(word);
//         }
        
//         return helper(s, set);
        // return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
    private boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
    
    private boolean helper (String s, Set<String> set) {
        if (s.length() == 0) {
            return true;
        }
        
        
        for (int i = 1; i <= s.length(); i++) {
            if (set.contains(s.substring(0, i)) && helper(s.substring(i), set)) {
                return true;
            }
        }
        
        return false;
    }
}