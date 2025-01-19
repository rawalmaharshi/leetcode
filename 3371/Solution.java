class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0, answer = Integer.MIN_VALUE;

        for (int num : nums) {
            total += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            int outlier = total - num - num;  //total = sum + outlier + sum (n-2 element)
            if (map.getOrDefault(outlier, 0) > (outlier == num ? 1 : 0)) {
                answer = Math.max(answer, outlier);
            }
        }

        return answer;
    }
}

/*
    Algo:
    1. Calculate the total sum of the array and store the frequency of each element in a map.
    2. For each element in the array, calculate the outlier by subtracting the element from the total sum.
    3. If the outlier is present in the map and the frequency of the outlier is greater than 1 
      (if the outlier is the same as the element, then the frequency should be greater than 1),
       update the answer.
    4. Return the answer.

    Time complexity: O(n)
    Space complexity: O(n)
 */