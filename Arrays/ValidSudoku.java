class Solution {
    /**
     * LeetCode #36 - Valid Sudoku
     *
     * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need
     * to be validated according to the standard rules:
     * 1. Each row must contain digits 1-9 without repetition.
     * 2. Each column must contain digits 1-9 without repetition.
     * 3. Each 3x3 sub-box must contain digits 1-9 without repetition.
     *
     * Time Complexity: O(1) as the board size is fixed at 9x9 (81 cells).
     * Space Complexity: O(1) for fixed boolean tracking arrays.
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') {
                    continue;
                }

                int digit = ch - '1';
                int boxIndex = (r / 3) * 3 + (c / 3);

                if (rows[r][digit] || cols[c][digit] || boxes[boxIndex][digit]) {
                    return false;
                }

                rows[r][digit] = true;
                cols[c][digit] = true;
                boxes[boxIndex][digit] = true;
            }
        }

        return true;
    }
}
