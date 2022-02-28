class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // return bruteForce(nums);
        return optimized(nums);
    }
    
    public List<List<Integer>> optimized(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> smallAns = new ArrayList<>();
                    smallAns.add(nums[i]);
                    smallAns.add(nums[left]);
                    smallAns.add(nums[right]);
                    if (!answer.contains(smallAns)) answer.add(smallAns);
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return answer;
    }
    
    public List<List<Integer>> bruteForce(int[] nums) {
        //Time Complexity: O(n3), S: 0(1)
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> smallAns = new ArrayList<>();
                        smallAns.add(nums[i]);
                        smallAns.add(nums[j]);
                        smallAns.add(nums[k]);
                        if (!answer.contains(smallAns)) answer.add(smallAns);
                    }
                }
            }
        }
        return answer;
    }
}