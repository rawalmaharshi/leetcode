class Solution {
    public int myAtoi(String s) {
        s = s.trim().split(" ")[0];
        int answer = 0;
        boolean negative = false;
        char[] sChars;
        if (s.length() == 0)    return 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            if (s.charAt(0) == '-') negative = true;
            s = s.substring(1, s.length());
        } 
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            if (sb.length() == 0 && s.charAt(i) == '0') continue;
            sb.append(s.charAt(i));
        }
        sChars = sb.toString().toCharArray();
        
        int pow10 = sChars.length - 1;
        System.out.println("Char Array: " + Arrays.toString(sChars) + ", Negative: " + negative + ", Pow 10: " + pow10);
        for (char c : sChars) {
            if (!Character.isDigit(c)) {
                break;
            }
            
            if (sChars.length > 9 && (answer + Character.getNumericValue(c) * Math.pow(10, pow10) > Integer.MAX_VALUE)) {
                return negative == true ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            answer += Character.getNumericValue(c) * Math.pow(10, pow10);
            pow10--;
        }
        
        return negative == true ? -1 * answer : answer;
    }
}