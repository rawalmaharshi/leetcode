class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1 = 0, w2 = 0;
        int m = word1.length(), n = word2.length();

        StringBuilder sb = new StringBuilder();
        
        while (w1 < m && w2 < n) {
            sb.append(word1.charAt(w1++));
            sb.append(word2.charAt(w2++));
        }

        while (w1 < m) {
            sb.append(word1.charAt(w1++));
        }

        while (w2 < n) {
            sb.append(word2.charAt(w2++));
        }

        return sb.toString();
    }
}