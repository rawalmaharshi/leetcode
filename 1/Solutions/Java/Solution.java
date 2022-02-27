class Solution {
    public int[] twoSum(int[] nums, int target) {
        // return bruteForce(nums, target);
        // return twoPassHM(nums, target);
        return onePassHM(nums, target);
    }
    
    public int[] onePassHM(int[] nums, int target) {
        //number to index map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
                
        return new int[] {-1, -1};
    }
    
    public int[] twoPassHM(int[] nums, int target) {
        //number to index map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if ((map.containsKey(target - nums[i])) && map.get(target - nums[i]) != i) {
                return new int[] {i, map.get(target - nums[i])};
            }
        }
        
        return new int[] {-1, -1};
    }
    
    public int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        
        return new int[] {-1, -1};
    }
}