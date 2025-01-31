class Solution {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        int max = 0;
        for (int milestone : milestones) {
            max = Math.max(max, milestone);
            sum += milestone;
        }

        long sumMinusMax = sum - max;  //Sum of array without the max element
        if (max - sumMinusMax > 1) {
            return sum - (max - sumMinusMax - 1);
        }

        return sum;
    }
}

/*
    Algo -
    1. Find the sum of all elements in the array and the maximum element in the array.
    2. If the maximum element is greater than the sum of all elements except the maximum element -
        then the maximum element can be completed in the remaining sum of elements.
       else
        then the maximum element can be completed in the sum of all elements.
    3. Return the result.

    Time complexity - O(n)
    Space complexity - O(1)
*/