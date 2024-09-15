class Solution {
    public int myAtoi(String s) {
        String s1 = s.trim();
        
        //edge case
        if (s1 == null || s1.length() == 0) {
            return 0;
        }

        boolean isNeg = s1.charAt(0) == '-' ? true : false;
        if (s1.charAt(0) == '+') {
            s1 = s1.substring(1);
        }
        int answer = 0;

        for (int i = isNeg ? 1 : 0; i < s1.length(); i++) {
            if (!Character.isDigit(s1.charAt(i))) {
                break;
            }
            int digit = s1.charAt(i) - '0';
            if (answer == 0 && digit == 0) {
                continue;
            }

            if ((answer > Integer.MAX_VALUE/10) || (answer == Integer.MAX_VALUE/10 && digit > 7)) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            answer = answer * 10 + digit;
        }
    
        return isNeg ? -1 * answer : answer;
    }
}