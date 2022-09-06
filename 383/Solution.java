class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCountMagazine = new int[26];
        for (char c : magazine.toCharArray()) {
            charCountMagazine[c - 'a']++;
        }
        
        for (char c : ransomNote.toCharArray()) {
            charCountMagazine[c - 'a']--;
            
            //check if count < 0 [magazine doesn't contain that character]
            if (charCountMagazine[c - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
}