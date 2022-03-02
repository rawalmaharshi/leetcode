class Solution {
    public boolean isAnagram(String s, String t) {
        //Method 1: HashMap of Count
        //Method 2: toCharArray, Array sort -> check equal
        
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        
        for (char c : s.toCharArray()) {
            sCount[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            tCount[c - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != tCount[i]) {
                return false;
            }
        }
        
        return true;
    }
}