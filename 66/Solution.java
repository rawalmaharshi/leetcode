class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1, n = digits.length - 1;
        
        while (n >= 0 && carry == 1) {
            int sum = digits[n] + carry;
            digits[n] = sum % 10;
            carry = sum / 10;
            n--;
        }

        //edge case (9, 99, 999, etc)
        if (n < 0 && carry != 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }
}

/*
    Algo:
    1. Start from the last element of array and add 1 to it.
    2. Update the last element with sum % 10
    3. Update carry with sum / 10.
    4. Repeat the above steps for all elements of array.
    5. If carry is still 1, then create a new array of size n + 1 and set first element to 1.

    Time Complexity: O(n)
    Space Complexity: O(n) (worst case)
 */