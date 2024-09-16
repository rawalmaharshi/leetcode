class Solution {
  public boolean exist(char[][] board, String word) {
      //edge case
      if (board == null || board.length == 0 || word == null || word.length() == 0) {
          return false;
      }

      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
              if (backtrack(board, word, i, j, 0)) {
                  return true;
              }
          }
      }

      return false;
  }

  private boolean backtrack(char[][] board, String word, int i, int j, int index) {
      //end case
      if (index >= word.length()) {
          return true;
      }

      //base case
      if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
          return false;
      }

      int[][] directions = {
          {1, 0}, {-1, 0}, {0, 1}, {0, -1}
      };

      for (int[] direction : directions) {
          //add (update)
          board[i][j] = '*';

          //recurse
          int neighborI = i + direction[0];
          int neighborJ = j + direction[1];

          //Here if the word is found - stop and return true
          if (backtrack(board, word, neighborI, neighborJ, index + 1)) {
              return true;
          }

          //remove (undo)
          board[i][j] = word.charAt(index);
      }

      return false;
  }
}