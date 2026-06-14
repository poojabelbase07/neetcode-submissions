class Solution {

    private int rows;
    private int cols;
    private int[][] memo;

    private final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int longestIncreasingPath(int[][] matrix) {

        rows = matrix.length;
        cols = matrix[0].length;

        memo = new int[rows][cols];

        int longestPath = 0;

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                longestPath = Math.max(
                    longestPath,
                    dfs(matrix, row, col)
                );
            }
        }

        return longestPath;
    }

    private int dfs(int[][] matrix, int row, int col) {

        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int maxLength = 1;

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < rows &&
                newCol >= 0 && newCol < cols &&
                matrix[newRow][newCol] > matrix[row][col]) {

                maxLength = Math.max(
                    maxLength,
                    1 + dfs(matrix, newRow, newCol)
                );
            }
        }

        memo[row][col] = maxLength;
        return maxLength;
    }
}