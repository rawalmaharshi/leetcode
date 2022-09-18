class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumHelper(candidates, new ArrayList<>(), 0, 0, target);
        return answer;
    }
    
    public void combinationSumHelper(int[] candidates, List<Integer> currList, int currSum, int start, int target) {
        //base case
        if (currSum == target) {
            answer.add(new ArrayList<>(currList));
            return ;
        }
        
        //combination sum not possible
        if (currSum > target) {
            return ;
        }
        
        for (int i = start; i < candidates.length; i++) {
            currSum += candidates[i];
            currList.add(candidates[i]);
            
            //recurse
            combinationSumHelper(candidates, currList, currSum, i, target);
            
            //remove
            currSum -= candidates[i];
            currList.remove(currList.size() - 1);
        }
        
        return ;
    }
}