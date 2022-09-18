class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(nums, 0, new ArrayList<>());
        return answer;
    }
    
    private void subsetsHelper(int[] nums, int start, List<Integer> currList) {
        //base case
        if (nums.length == currList.size()) {
            answer.add(new ArrayList<>(currList));
            return ;
        }  
        
        //To add to answer
        answer.add(new ArrayList<>(currList));
        
        for (int i = start; i < nums.length; i++) {
            //check if present
            if (currList.contains(nums[i])) {
                continue;    
            }
            
            //add
            currList.add(nums[i]);
            
            //recurse
            subsetsHelper(nums, i, currList);
            
            //remove
            currList.remove(currList.size() - 1);
            
        }
        
        return ;
    }
}