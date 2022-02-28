class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int num = 1;
        int r1 = 0, c1 = 0;
        int r2 = n - 1, c2 = n - 1;
        while (num <= (n * n)) {
            for (int j = c1; j <= c2; j++)  ans[r1][j] = num++;
            for (int i = r1 + 1; i <= r2; i++)  ans[i][c2] = num++;
            for (int j = c2 - 1; j >= c1; j--)   ans[r2][j] = num++;
            for (int i = r2 - 1; i > r1; i--)   ans[i][c1] = num++;
            r1++;
            c1++;
            r2--;
            c2--;
        }
        
        return ans;
    }
}