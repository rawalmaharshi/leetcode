class Solution {
    protected boolean backtrack(int row, int col, String word, int index) {
    /* Step 1). check the bottom case. */
        if (index >= word.length())
          return true;

        /* Step 2). Check the boundaries. */
        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
            || this.board[row][col] != word.charAt(index))
          return false;

        /* Step 3). explore the neighbors in DFS */
        // mark the path before the next exploration
        this.board[row][col] = '#';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
          if (this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1))
            // return without cleanup
            return true;
        }

        /* Step 4). clean up and return the result. */
        this.board[row][col] = word.charAt(index);
        return false;
    }
    
      private char[][] board;
      private int ROWS;
      private int COLS;

      public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row)
          for (int col = 0; col < this.COLS; ++col)
            if (this.backtrack(row, col, word, 0))
              return true;
        return false;
      }
    
    
//     boolean answer = false;
//     public boolean exist(char[][] board, String word) {
//         //edge case
//         if (board.length == 0 || word.length() == 0) {
//             return answer;
//         }
        
//         int currentIndex = 0;
//         for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board[i].length; j++) {
//                 if (board[i][j] == word.charAt(0)) {
//                     //start dfs
//                     dfsHelper(board, i, j, word, currentIndex);
//                 }
//             }
//         }
        
//         return answer;
//     }
    
//     public void dfsHelper(char[][] board, int i, int j, String word, int currIndex) {
//         //base case
//         if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
//             return ;
//         }
        
//         //stop (reached the end of word)
//         if (currIndex == word.length() - 1 && board[i][j] == word.charAt(currIndex)) {
//             answer = true;
//             return;
//         }
        
//         if (word.charAt(currIndex) != board[i][j]) return;  //No need to perform dfs further
        
//         int[][] directions = new int[][] {{-1,0}, {1, 0}, {0,-1}, {0,1}};
//         char origChar = board[i][j];
//         board[i][j] = '0';
//         for (int [] dir : directions) {
//             int xC = i + dir[0];
//             int yC = j + dir[1];
            
//             dfsHelper(board, xC, yC, word, currIndex + 1);
//         }
//         board[i][j] = origChar;
//     }
}