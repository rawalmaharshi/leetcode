class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
            1. See if the target falls in the range of the given row
            2. Apply binary search on that row
         */
        for (int i = 0; i < matrix.length; i++) {
            int j1 = 0, j2 = matrix[0].length - 1;
            if (target >= matrix[i][j1] && target <= matrix[i][j2]) {
                return binarySearch(matrix[i], target);
            }
        }

        return false;
    }

    private boolean binarySearch(int[] row, int target) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] > target) {
                right = mid - 1;
            } else if (row[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}