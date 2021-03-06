class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 1. 判断每一行是否有重复元素：rows[n][n] > 1? false: true
        // 2. 判断每一列是否有重复元素：cols[n][n] > 1? false: true
        // 3. 判断每一个子数独是否有重复元素：boxs[n][n] > 1? false: true
        // 子数独id的计算：(row / 3) * 3 + col / 3
        // 其他：len是一个固定值9。

        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] boxs = new int[9][10];

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                rows[i][num]++;
                cols[j][num]++;
                boxs[(i/3)*3 + j/3][num]++;
                if (rows[i][num] + cols[j][num] + boxs[(i/3)*3 + j/3][num] > 3) {
                    return false;
                }
            }
        }
        return true;
    }
}
