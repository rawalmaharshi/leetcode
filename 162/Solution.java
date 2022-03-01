class Solution {
    public int findPeakElement(int[] nums) {
        return searchBinary(nums, 0, nums.length - 1); 
    }
    
    public int searchBinary(int[] nums, int sIndex, int eIndex) {
        if (sIndex == eIndex) {
            return sIndex;
        }
        int mIndex = sIndex + (eIndex - sIndex)/2;
        if (nums[mIndex] > nums[mIndex + 1]) {
            return searchBinary(nums, sIndex, mIndex);
        }
        return searchBinary(nums, mIndex + 1, eIndex);
    }
    
    public int solutionThatDidNotWork (int[] nums) {
        //edge case
        if (nums.length == 1) {
            return 0;
        }
        
        int sIndex = 0, eIndex = nums.length - 1;
        int ansIndex = 0;
        while (sIndex <= eIndex) {
            //when only one element is left
            if (sIndex == eIndex) {
                return ansIndex = sIndex;
            }
            
            int mIndex = sIndex + (eIndex - sIndex)/2;
            //for two elements
            if (mIndex == sIndex || mIndex == eIndex) {
                return ansIndex = nums[sIndex] > nums[eIndex] ? sIndex : eIndex;
            }
            
            //check if midElement is greater than neighboring elements
            if (nums[mIndex] > nums[mIndex - 1] && nums[mIndex] > nums[mIndex + 1]) {
                return ansIndex = mIndex;  //found peak
            }
            
            if (nums[sIndex] >= nums[eIndex]) {
                //check on left side, more probability of finding peak there.
                //our intuition is to go towards bigger element in order to have higher probability of finding peak
                eIndex = mIndex - 1;
            } else {
                sIndex = mIndex + 1;
            }
        }
        return ansIndex;
    }
    
    public int findPeakBruteForce(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
        int peakIndex = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return peakIndex = i;
            }
        }
        
        //edge case for last element
        if (peakIndex == 0) {
            peakIndex = nums[nums.length - 1] > nums[nums.length - 2] ? nums.length - 1 : peakIndex;
        }
        return peakIndex;
    }
}