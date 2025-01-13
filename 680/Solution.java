class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int left = 0, right = s.length() - 1;
        //it is a palindrome in case the current string is palindrome or else after removing one character (from either sides)
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

/*
    Algo: 
    1. Create a helper function to check if a string is palindrome
    2. Check if the string is palindrome or else after removing one character (from either sides)
    3. This can be achieved by traversing the string from both ends and checking if the characters are same
    4. If not, then call helper function to check if the string is palindrome after removing one character from either side

    Time Complexity: O(N)
    Space Complexity: O(1)
 */