class Solution {
    public void moveZeroes(int[] nums) {
        // moveZeroNonOptimized(nums);
        moveZeroOptimized(nums);
    }
    
    public void moveZeroOptimized(int[] nums) {
        int lastNonZeroLocation = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, lastNonZeroLocation++, i);
            }
        }
    }
    
    public void swap(int[] nums, int lnz, int i) {
        int temp = nums[lnz];
        nums[lnz] = nums[i];
        nums[i] = temp;
    }
    
    public void moveZeroNonOptimized(int[] nums) {
        int lastNonZeroLocation = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroLocation++] = nums[i];
            }
        }
        
        for (int i = lastNonZeroLocation; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}