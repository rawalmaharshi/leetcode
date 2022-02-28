class Solution {
    List<List<String>> answer = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        //edge case - no answers for n = 2 and 3
        if (n == 2 || n == 3) {
            return answer;
        }
        
        placeQueen(new int[n][n], 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return answer;
    }
    
    public void placeQueen(int[][] board, int i, Set<Integer> diagonal1, Set<Integer> diagonal2, Set<Integer> column) {
        //base case
        if (i == board.length) {
            addAnswer(board);
            return ;
        }
        
        //place Queens on the board depending on conditions; also for backtracing - displace them
        for (int j = 0; j < board.length; j++) {
            if (!diagonal1.contains(i + j) && !diagonal2.contains(j - i) && !column.contains(j)) {
                //place queen
                board[i][j] = 1;
                diagonal1.add(i + j);
                diagonal2.add(j - i);
                column.add(j);
                
                //recurse
                placeQueen(board, i + 1, diagonal1, diagonal2, column);
                
                //remove for backtracking
                board[i][j] = 0;
                diagonal1.remove(i + j);
                diagonal2.remove(j - i);
                column.remove(j);
            }
        }
        
        return;
    }
    
    public void addAnswer(int[][] board) {
        List<String> smallAns = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            smallAns.add(sb.toString());
        }
        answer.add(smallAns);
        return ;
    }
}