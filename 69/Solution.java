class Solution {
    public int mySqrt(int x) {
        //edge case for 0 and 1
        if (x < 2) {
            return x;
        }

        int left = 2, right = x/2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midSq = (long) mid * mid;

            if (midSq == x) {
                return mid;
            } else if (midSq < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}