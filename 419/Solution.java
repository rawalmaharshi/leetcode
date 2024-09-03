class Solution {
    public int countBattleships(char[][] board) {
        //edge case
        if (board == null || board.length == 0) {
            return 0;
        }

        // return graphHelper(board);
        return optimized(board);
    }

    /**
        Algorithm - We only count the first cell of the battleship.
        First cell is the top-left cell of the battleship.

        It is identified as the cell that does not have 'X' to
        the left AND above it.
     */
    private int optimized(char[][] board) {
        int numShips = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                } else if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }

                numShips++;
            }
        }

        return numShips;
    }

    private int graphHelper(char[][] board) {
        int numShips = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    numShips++;
                    // bfs(board, i, j);
                    dfs(board, i, j);
                }
            }
        }

        return numShips;
    }

    private void dfs(char[][] board, int i, int j) {
        //base case
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.') {
            return ;
        }

        //mark visited
        board[i][j] = '.';

        //dfs
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);

        return ;
    }

    private void bfs(char[][] board, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int q = 0; q < queueSize; q++) {
                int[] coord = queue.poll();
                int x = coord[0], y = coord[1];

                //validate
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '.') {
                    continue;
                }

                //mark visited
                board[x][y] = '.';

                //bfs
                queue.offer(new int[]{x + 1, y});
                queue.offer(new int[]{x - 1, y});
                queue.offer(new int[]{x, y + 1});
                queue.offer(new int[]{x, y - 1});
            }
        }

        return ;
    }
}