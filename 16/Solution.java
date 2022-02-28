class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // return bruteForceHelper(nums, target);
        return optimizedHelper(nums, target);
    }
    
    public int optimizedHelper(int[] nums, int target) {
        int currMinSum = Integer.MAX_VALUE;
        int answer = 0;
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum-target) < currMinSum) {
                    currMinSum = Math.abs(sum - target);
                    answer = sum;
                }
                
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return answer;
    }
    
    public int bruteForceHelper(int[] nums, int target) {
        int currMinSum = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum - target) < currMinSum) {
                        currMinSum = Math.abs(sum - target);
                        answer = sum;
                    }
                }
            }
        }
        return answer;
    }
}