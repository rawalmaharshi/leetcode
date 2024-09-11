class Solution1 {
    public int longestPalindrome(String s) {
        int[] count = new int[52];
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                count[c - 'a']++;
            } else {
                count[c - 'A' + 26]++;
            }
        }

        int answer = 0;
        for (int currCount : count) {
            if (currCount >= 2) {
                while (currCount >= 2) {
                    answer += 2;
                    currCount -= 2;
                }
            }
        }

        //Add one character for odd length string as it can have a different middle character
        return answer < s.length() ? answer + 1 : answer;
    }
}