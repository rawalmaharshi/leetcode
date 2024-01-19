class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      return combinationSumHelper(candidates, target, new ArrayList<>(), new ArrayList<>(), 0, 0);
  }

  private List<List<Integer>> combinationSumHelper(int[] candidates, int target, List<List<Integer>> answer, List<Integer> currList, int start, int currSum) {
      //base case
      if (currSum == target) {
          answer.add(new ArrayList<>(currList));
          return answer;
      }

      //combination sum not possible
      if (currSum > target) {
          return answer;
      }

      for (int i = start; i < candidates.length; i++) {
          //add
          currSum += candidates[i];
          currList.add(candidates[i]);

          //recurse
          combinationSumHelper(candidates, target, answer, currList, i, currSum);

          //remove
          currSum -= candidates[i];
          currList.remove(currList.size() - 1);
      }

      return answer;
  }
}