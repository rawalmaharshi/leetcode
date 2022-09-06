class Solution {
    public int majorityElement(int[] nums) {
        // return intuitiveApproach(nums);
        return boyer_moore_voting_algorithm(nums);
    }
    
    public int boyer_moore_voting_algorithm(int[] nums) {
        //T: O(n), S: O(1)
        int count = 0;
        int candidate = -1;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
    
    public int intuitiveApproach(int[] nums) {
        //T: O(n), S: O(n)
        int majorityNumber = nums.length/2;
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int i : nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
            if (countMap.get(i) > majorityNumber) {
                return i;
            }
        }
        
        //Doesn't reach here
        return -1;
    }
}