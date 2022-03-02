class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] p = pattern.toCharArray();
        String[] sA = s.split(" ");
        
        //edge case
        if (p.length != sA.length) {
            return false;
        }
        
        Map<String, Character> map = new HashMap<>();
        Set<Character> storedChars = new HashSet<>();
        for (int i = 0; i < p.length; i++) {
            if (!map.containsKey(sA[i])) {
                if (!storedChars.contains(p[i])) {
                    map.put(sA[i], p[i]);
                    storedChars.add(p[i]);
                } else {
                    return false;
                }
            } else {
                if (!map.get(sA[i]).equals(p[i])) {
                    return false;
                }
            }
        }
        
        return true;
    }
}