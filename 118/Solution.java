class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> smallAns = new ArrayList<>(i + 1);
            List<Integer> prevList = null;
            if (i > 1)  prevList = answer.get(i - 1);
            for (int j = 0; j < (i + 1); j++) {
                if (j == 0 || j == i) {
                    smallAns.add(1);
                } else {
                    int element = prevList.get(j - 1) + prevList.get(j);
                    smallAns.add(element);
                }
            }
            answer.add(smallAns);
        }
        return answer;
    }
}