class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        
        Arrays.sort(nums);
        Set<List<Integer>> answer = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    List<Integer> smallAns = List.of(nums[left], nums[i], nums[right]);
                    answer.add(smallAns);
                    left++;
                    right--;
                }
            }
        }
        
        return answer.stream().toList();
    }
}

/*
    Algo:
    1. Sort the array
    2. For each element, find the other two elements using two pointer approach
        2a. If sum is less than 0, increment left pointer
        2b. If sum is greater than 0, decrement right pointer
        2c. If sum is equal to 0, add the elements to the answer
    3. Return the answer
    Time Complexity: O(nlogn) + O(n^2) = O(n^2)
    Space Complexity: O(n)
 */