class Solution {
    public int fillCups(int[] amount) {
        int max = 0, sum = 0;
        for (int curr : amount) {
            max = Math.max(max, curr);
            sum += curr;
        }

        return Math.max(max, (sum + 1)/ 2);
    }
}

/*
    Algo: 
    1. Find max and sum of all elements
    2. Return max of max and (sum + 1) / 2
    T.C. - O(N)
    S.C. - O(1)

    Example when (sum + 1)/2 is used - [5,4,4] - 7
    Example when max is used - [5,0,3] - 5
*/