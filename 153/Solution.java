class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] > nums[hi]) {
                //there are smallers numbers to the right of mid - search right
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return nums[lo];
    }
}