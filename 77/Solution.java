class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1, new HashSet<Integer>());
        return answer;
    }

    private void combineHelper(int n, int k, int start, Set<Integer> currSet) {
        //end case
        if (currSet.size() == k) {
            answer.add(new ArrayList<>(currSet));
            return ;
        }

        for (int i = start; i <= n; i++) {
            //add
            currSet.add(i);

            //recurse
            combineHelper(n, k, i + 1, currSet);

            //remove
            currSet.remove(i);
        }

        return ;
    }
}