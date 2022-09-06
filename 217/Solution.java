class Solution {
    public boolean containsDuplicate(int[] nums) {
        return usingSet(nums);
    }
    
    public boolean usingSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}