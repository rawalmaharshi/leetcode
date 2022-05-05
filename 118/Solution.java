class Solution {
    public List<List<Integer>> generate(int numRows) {
        // return iterativeHelper(numRows);
        return recursiveHelper(numRows);
    }
    
    public List<List<Integer>> recursiveHelper(int numRows) {
        //base case
        if (numRows == 1) {
            List<Integer> smallAns = Arrays.asList(1);
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(smallAns);
            return ans;
        }
        
        List<List<Integer>> smallAns = recursiveHelper(numRows - 1);
        List<List<Integer>> ans = new ArrayList<>();
        //add prev smallAns to ans
        ans.addAll(smallAns);
        
        List<Integer> currListToAdd = new ArrayList<>();
        List<Integer> prevList = smallAns.get(numRows - 2);
        currListToAdd.add(1);
        for (int i = 1; i < prevList.size(); i++) {
            currListToAdd.add(prevList.get(i - 1) + prevList.get(i));
        }
        currListToAdd.add(1);
        ans.add(currListToAdd);
        
        return ans;
    }
    
    public List<List<Integer>> iterativeHelper(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> rowOneList = Arrays.asList(1);
        answer.add(rowOneList);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = answer.get(i - 1);
            List<Integer> currRowList = new ArrayList<>();
            //1st and last element are always null
            currRowList.add(1);
            for (int j = 1; j < prevRow.size(); j++) {
                currRowList.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currRowList.add(1);
            
            //add current list to answer;
            answer.add(currRowList);
        }
        
        return answer;
    }
}