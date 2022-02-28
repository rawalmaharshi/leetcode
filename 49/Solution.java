class Solution {
    //time complexity is nk
    public List<List<String>> groupAnagrams(String[] strs) {        
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] chCount = new int[26];
            //Store the char count
            for (char c : str.toCharArray()) {
                chCount[c - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chCount.length; i++) {
                if (chCount[i] > 0) {
                    sb.append((char) (i + 'a'));
                    sb.append(chCount[i]);
                }
            }
            
            String key = sb.toString();
            if (!map.containsKey(key)) {
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(key, l);
            } else {
                List<String> l = map.get(key);
                l.add(str);
                map.put(key, l);
            }
        }
        
        for (String key : map.keySet()) {
            answer.add(map.get(key));
        }
        
        return answer;
    }
    
    //Time Complexity is nk(LOGk)
    public List<List<String>> groupAnagrams2(String[] strs) {        
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String s2 = String.valueOf(arr);
            if (!map.containsKey(s2)) {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(s2, l);
            } else {
                List<String> l = map.get(s2);
                l.add(s);
                map.put(s2, l);
            }
        }
        
        for (String key : map.keySet()) {
            answer.add(map.get(key));
        }
        
        return answer;
    }
}