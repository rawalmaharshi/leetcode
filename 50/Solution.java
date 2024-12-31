class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0/helper(x, (long) -n);
        }

        return helper(x, (long) n);
    }

    // T: O(logn), S: O(logn)
    //Power ko half kr rhe hai aur base ko square kr rhe hai hr recursion step mei
    private double helper(double x, long n) {
        //base case
        if (n == 0) {
            return 1.0;
        }

        //n is odd
        if (n % 2 != 0) {
            return x * helper(x * x, n/2);
        }

        return helper(x * x, n/2);
    }

    //This causes stackoverflow/TLE
    private double helper2(double x, long n) {
        //base case
        if (n == 0) {
            return 1.0;
        }

        return x * helper2(x, n - 1);
    }
}