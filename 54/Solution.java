class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, c1 = 0;
        int r2 = matrix.length - 1, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            // for (int i = r1; i <= r2; i++)    ans.add(matrix[i][c1]);
            for (int i = c1; i <= c2; i++)    ans.add(matrix[r1][i]);
            
            // for (int j = c1 + 1; j <= c2; j++)  ans.add(matrix[r2][j]);
            for (int j = r1 + 1; j <= r2; j++)  ans.add(matrix[j][c2]);
            
            
            if (r1 < r2 && c1 < c2) {
                // for (int i = r2 - 1; i >= c1; i--)   ans.add(matrix[i][c2]);
                for (int i = c2 - 1; i >= c1; i--)  ans.add(matrix[r2][i]);
            
                // for (int j = c2 - 1; j > r1; j--)   ans.add(matrix[r1][j]);
                for (int j = r2 - 1; j > r1; j--)   ans.add(matrix[j][c1]);   
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        
        return ans;
    }
}