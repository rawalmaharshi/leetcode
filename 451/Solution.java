class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        map = sortByFreq(map);
        StringBuilder sb = new StringBuilder();
        Set<Character> keys = map.keySet();
        for (Character key : keys) {
            int count = map.get(key);
            while (count-- > 0) {
                sb.append(key);
            }
        }
        
        return sb.toString();
    }
    
    public Map<Character, Integer> sortByFreq(Map<Character, Integer> inputMap) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : inputMap.entrySet()) {
            list.add(entry);
        }
        
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
           @Override
           public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
               return b.getValue().compareTo(a.getValue());
           }
        });
        
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());    
        }
        
        return sortedMap;
    }
}


class Solution2 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (Character key : map.keySet()) {
            pq.offer(key);
        }
        
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            char c = pq.poll();
            int count = map.get(c);
            while (count-- > 0) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
    
    public Map<Character, Integer> sortByFreq(Map<Character, Integer> inputMap) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : inputMap.entrySet()) {
            list.add(entry);
        }
        
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
           @Override
           public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
               return b.getValue().compareTo(a.getValue());
           }
        });
        
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());    
        }
        
        return sortedMap;
    }
}