/*
79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        if (board.length * board[0].length < word.length()) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(board, word, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean check(char[][] board, String word, int i, int j) {
        if (word.length() == 0) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] != word.charAt(0)) return false;
        char temp = board[i][j];
        board[i][j] = '0';
        word = word.substring(1);
        if (check(board, word, i - 1, j) || check(board, word, i, j + 1) ||
                check(board, word, i + 1, j) || check(board, word, i, j - 1)) return true;
        board[i][j] = temp;
        return false;
    }
}
