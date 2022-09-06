class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        int answer = 0;
        for (int currCount : count) {
            answer += currCount / 2 * 2;
            if (answer % 2 == 0 && currCount % 2 == 1) {
                answer++;
            }
        }
        
        return answer;
    }
}