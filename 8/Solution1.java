class Solution {
    public int myAtoi(String s) {
        List<Integer> digits = new ArrayList<>();
        String s1 = s.trim();
        //edge case
        if (s1 == null || s1.length() == 0) {
            return 0;
        }

        boolean isNegative = s1.charAt(0) == '-' ? true : false;

        //trim '+' character if present
        if (s1.charAt(0) == '+') {
            s1 = s1.substring(1);
        }

        //starting iteration from 0 or 1 depending on negative/positive number
        for (int i = (isNegative ? 1 : 0); i < s1.length(); i++) {
            //will add digits to the array list
            
            //if a non-digit character is encountered; break out of loop
            if (s1.charAt(i) < '0' || s1.charAt(i) > '9') {
                break;
            }

            //to skip leading zeros will just check if digits have been added to the list; in case a zero is encountered and if list size is 0, the current 0 is a leading zero
            if (s1.charAt(i) == '0' && digits.size() == 0) {
                continue;
            }

            digits.add(s1.charAt(i) - '0');
        }

        int answer = 0;
        for (int i = 0; i < digits.size(); i++) {
            //check overflow/underflow conditions
            if (
                (answer > Integer.MAX_VALUE / 10) || 
                (answer == Integer.MAX_VALUE / 10 && digits.get(i) > Integer.MAX_VALUE % 10)
                ) {
                // If integer overflowed return 2^31-1, otherwise if underflowed
                // return -2^31.
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            answer = answer * 10 + digits.get(i);
        }

        return isNegative ? (-1) * answer : answer;
    }
}