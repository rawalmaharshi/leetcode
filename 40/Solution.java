class Solution {
    Set<List<Integer>> answer = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, 0, 0, new ArrayList<>());
        return new ArrayList<>(answer);
    }

    private void combinationSum2Helper(int[] candidates, int target, int start, int currSum, List<Integer> currList) {
        //end case
        if (currSum == target) {
            answer.add(new ArrayList<>(currList));
            return ;
        }

        //target not possible
        if (currSum > target) {
            return ;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            //add
            currList.add(candidates[i]);
            currSum += candidates[i];

            //recurse
            combinationSum2Helper(candidates, target, i + 1, currSum, currList);

            //remove
            currList.remove(currList.size() - 1);
            currSum -= candidates[i];
        }

        return ;
    }
}