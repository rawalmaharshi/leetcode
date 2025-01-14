class Solution {
    /* 
        1. Use a two pointer for iterating two strings
        2. If the current characters are not same return false
        3. When a digit is encounterd in abbr, increment counter till the number is formed
        4. Find the number and increment counter in word by that
        5. Repeat steps 2-4
        TC: O(m + n)
        SC: O(1)
    */
    public boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length(), n = abbr.length();
        int wPtr = 0, aPtr = 0;

        while (wPtr < m && aPtr < n) {
            if (isLetter(abbr.charAt(aPtr))) {
                if (word.charAt(wPtr) != abbr.charAt(aPtr)) {
                    return false;
                }
                wPtr++;
                aPtr++;
            } else {
                //find the number to replace
                int num = 0;
                while (aPtr < n && isDigit(abbr.charAt(aPtr))) {
                    int digit = abbr.charAt(aPtr) - '0';
                    //edge case (if num is 0 and zero is encountered - trailing zeros) 
                    if (num == 0 && digit == 0) {
                        return false;
                    }

                    num = num * 10 + digit;
                    aPtr++;
                }

                //found the number - increment word by this count 
                wPtr += num;
            }
        }

        //reached the end in both strings
        return wPtr == m && aPtr == n;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
}