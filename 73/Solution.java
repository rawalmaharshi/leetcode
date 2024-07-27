class Solution {
  public void setZeroes(int[][] matrix) {
      // usingSet(matrix);
      optimized(matrix);
  }

  public void optimized(int[][] matrix) {
      //Approach - Set the first element in respective row/column as zero
      
      boolean firstRowZero = false;
      boolean firstColZero = false;

      //1st pass
      for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix[0].length; j++) {
              if (matrix[i][j] == 0) {
                  if (i == 0) {
                      firstRowZero = true;
                  }

                  if (j == 0) {
                      firstColZero = true;
                  }

                  matrix[i][0] = 0;
                  matrix[0][j] = 0;
              }
          }
      }

      //2nd pass
      //Need to start from 2nd row/col bcoz if the 1st row/col is marked as zero - the whole matrix becomes zero
      //Need to mark 1st row/col in the end
      for (int i = 1; i < matrix.length; i++) {
          for (int j = 1; j < matrix[0].length; j++) {
              if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                  matrix[i][j] = 0;
              }
          }
      }

      // 1st row
      if (firstRowZero) {
          for (int j = 0; j < matrix[0].length; j++) {
              matrix[0][j] = 0;
          }
      }

      // 1st col
      if (firstColZero) {
          for (int i = 0; i < matrix.length; i++) {
              matrix[i][0] = 0;
          }
      }

      return ;
  }

  public void usingSet(int[][] matrix) {
      Set<Integer> rowSet = new HashSet<>();
      Set<Integer> colSet = new HashSet<>();
      
      //1st pass
      for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix[0].length; j++) {
              if (matrix[i][j] == 0) {
                  rowSet.add(i);
                  colSet.add(j);
              }
          }
      }
      
      //2nd pass - set zero 
      for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix[0].length; j++) {
              if (rowSet.contains(i) || colSet.contains(j)) {
                  matrix[i][j] = 0;
              }
          }
      }
      
      return ;
  }
}