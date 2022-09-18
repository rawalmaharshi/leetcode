class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        //edge case
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        
        letterCombinationsHelper(digits, getMapping(), 0, new StringBuilder());
        return answer;
    }
    
    private void letterCombinationsHelper(String digits, Map<Integer, String> map, int index, StringBuilder sb) {
        //base case
        if (sb.length() == digits.length()) {
            answer.add(sb.toString());
            return ;
        }
        
        
        for (int i = index; i < digits.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(digits.charAt(i)));
            String mapping = map.get(digit);
        
            for (int j = 0; j < mapping.length(); j++) {
                //add
                char c = mapping.charAt(j);
                sb.append(c);
                
                //recurse
                letterCombinationsHelper(digits, map, i + 1, sb);
                
                //remove
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
        return ;
    }
    
    public Map<Integer, String> getMapping() {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        return map;
    }
}