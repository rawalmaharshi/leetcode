class Solution {
    public int firstUniqChar(String s) {
        // return usingHashMap(s);
        return usingArray(s);
    }    
    
    public int usingArray(String s) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) 
            charCount[s.charAt(i) - 'a']++;
        
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1)  return i; 
        }
        
        return -1;
    }
    
    public int usingHashMap(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        
        return -1;
    }
}