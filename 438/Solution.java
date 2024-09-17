class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // return usingHashMap(s, p);
        return usingArray(s, p);
    }

    private List<Integer> usingArray(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        //edge case
        if (sLen < pLen) {
            return new ArrayList<>();
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;  
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            sCount[c - 'a']++;

            //remove one letter from left side of window
            if (i >= pLen) {
                sCount[s.charAt(i - pLen) - 'a']--;
            }

            //comparing arrays
            if (Arrays.equals(pCount, sCount)) {
                answer.add(i - pLen + 1);
            }
        }

        return answer;
    }

    private List<Integer> usingHashMap(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        //edge case
        if (sLen < pLen) {
            return new ArrayList<>();
        }

        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> pCount = new HashMap<>();

        //Build a reference hashmap using string p
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        List<Integer> answer = new ArrayList<>();

        //sliding window on s
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);

            //remove one letter from left side of window
            if (i >= pLen) {
                c = s.charAt(i - pLen);
                if (sCount.get(c) == 1) {
                    sCount.remove(c);
                } else {
                    sCount.put(c, sCount.get(c) - 1);
                }
            }

            if (pCount.equals(sCount)) {
                answer.add(i - pLen + 1);
            }
        }

        return answer;
    }
}