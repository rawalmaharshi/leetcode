class Solution {
    public int[] sortedSquares(int[] nums) {
        // return bruteForce(nums);
        return optimized(nums);
    }
    
    public int[] bruteForce(int[] nums) {
        //Square then sort
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        
        Arrays.sort(nums);
        return nums;
    }
    
    public int[] optimized(int[] nums) {
        //two pointer (l & r),  the value in the squared array would be max of l and r, 
        //since the array is ascending the lowest value could indeed have the highest abs value
        int left = 0, right = nums.length - 1;
        int[] squared = new int[nums.length];
        int index = right;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                squared[index--] = nums[left] * nums[left];
                left++;
            } else {
                squared[index--] = nums[right] * nums[right];
                right--;
            }
        }
        
        return squared;
    }
}