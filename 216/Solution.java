class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return helper(k, n, 1, 0, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> helper(int k, int n, int start, int currSum, List<Integer> currList, List<List<Integer>> answer) {
        //end case
        if (currSum == n && currList.size() == k) {
            answer.add(new ArrayList<>(currList));
            return answer;
        }

        //combination sum not possible
        if (currSum > n) {
            return answer;
        }

        for (int i = start; i <= 9; i++) {
            if (currList.size() < k) {
                //add
                currSum += i;
                currList.add(i);

                //recurse
                helper(k, n, i + 1, currSum, currList, answer);

                //remove
                currSum -= i;
                currList.remove(currList.size() - 1);
            }
        }

        return answer;
    }
}