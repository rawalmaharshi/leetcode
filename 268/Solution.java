class Solution {
    public int missingNumber(int[] nums) {
        // return useSort(nums);
        // return useHashSet(nums);
        return useGaussFormula(nums);
    }
    
    public int useGaussFormula(int[] nums) {
        int numSum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            numSum += nums[i];
        }
        
        
        int shouldBeSum = n * (n + 1) / 2;
        return shouldBeSum - numSum;
    }
    
    public int useHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        
        return nums.length;
    }
    
    public int useSort(int[] nums) {
        //T: O(nlogn)
        //S: O(1)
        if (nums.length == 1) {
            return nums[0] == 0 ? 1 : 0;
        }
        
        Arrays.sort(nums);
        
        //ensure 0 is at the 1st index
        if (nums[0] != 0)   return 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return (nums[i] + 1);
            }
        }
        
        return nums.length;
    }
}