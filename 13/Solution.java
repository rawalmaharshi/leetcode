class Solution {
    public int romanToInt(String s) {
        //edge case
        if (s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        char[] ip = s.toCharArray();
        int answer = 0;
        for (int i = 0; i < ip.length - 1; i++) {
            if (ip[i] == 'I' && ((ip[i + 1] == 'V') || (ip[i + 1] == 'X'))) {
                answer -= map.get('I');
            } else if (ip[i] == 'X' && ((ip[i + 1] == 'L') || (ip[i + 1] == 'C'))) {
                answer -= map.get('X');
            } else if (ip[i] == 'C' && ((ip[i + 1] == 'D') || (ip[i + 1] == 'M'))) {
                answer -= map.get('C');
            } else {
                answer += map.get(ip[i]);
            }
        }
        
        answer += map.get(ip[ip.length - 1]); //for the last value to be added
        return answer;
    }
}