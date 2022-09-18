class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permuteHelper(nums, new ArrayList<>());
        return answer;
    }
    
    private void permuteHelper(int[] nums, List<Integer> currList) {
        //base case
        if (currList.size() == nums.length) {
            List<Integer> list = new ArrayList<>(currList);
            answer.add(list);
            return ;
        }
        
        for (int i = 0; i < nums.length; i++) {
            //ignore current element
            if (currList.contains(nums[i])) {
                continue;
            }
            
            //add
            currList.add(nums[i]);
            
            //recurse
            permuteHelper(nums, currList);
            
            //remove
            currList.remove(currList.size() - 1);
        }
        
        return ;
    }
}