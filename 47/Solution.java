class Solution {
    Set<List<Integer>> answer = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permuteUniqueHelper(nums, new ArrayList<>(), used);
        return new ArrayList<>(answer);
    }

    private void permuteUniqueHelper(int[] nums, List<Integer> currList, boolean[] used) {
        //end case
        if (currList.size() == nums.length) {
            /* 
            1. Using a hashset here since we don't want to add same items in the final answer. Duplicate check in arraylist is very expensive.
            2. doing a deep-copy of currList as it will get updated during backtracking so final answer will have inconsistent result otherwise
            */
            answer.add(new ArrayList<>(currList)); 
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                //add
                currList.add(nums[i]);
                used[i] = true;

                //recurse
                permuteUniqueHelper(nums, currList, used);

                //remove
                currList.remove(currList.size() - 1);
                used[i] = false;
            }
        }

        return ;
    }
}