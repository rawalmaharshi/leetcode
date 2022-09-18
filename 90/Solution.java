class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, 0, new ArrayList<>());
        return answer;
    }
    
    private void subsetsWithDupHelper(int[] nums, int start, List<Integer> currList) {
        //base case
        if (currList.size() == nums.length) {
            answer.add(new ArrayList<>(currList));
            return ;
        }
        
        //add to answer
        answer.add(new ArrayList<>(currList));
        
        for (int i = start; i < nums.length; i++) {
            //duplicate - ignore
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            //add
            currList.add(nums[i]);
            
            //recurse
            subsetsWithDupHelper(nums, i  + 1, currList);
            
            //remove
            currList.remove(currList.size() - 1);
        }
        
        return ;
    }
}