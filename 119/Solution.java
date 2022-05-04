class Solution {
    public List<Integer> getRow(int rowIndex) {
        return recursiveHelper(rowIndex);
    }
    
    public List<Integer> recursiveHelper(int rowIndex) {
        //base case
        if (rowIndex == 0) {
            List<Integer> list = Arrays.asList(1);
            return list;
        }
        
        List<Integer> smallList = recursiveHelper(rowIndex - 1);
        List<Integer> ansList = new ArrayList<>(smallList.size() + 1);
        //1st element is always 1
        ansList.add(1);
        
        for (int i = 1; i < smallList.size(); i++) {
            ansList.add(smallList.get(i - 1) + smallList.get(i));
        }
        //Last element is always 1 too
        ansList.add(1);
        
        return ansList;
    }
}