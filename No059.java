/*
59.Spiral Matrix2

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1, j = 0;
        while (num <= n * n) {
            for (int i = j; i < n - j; i++) {
                res[j][i] = num++;
            }
            for (int i = j + 1; i < n - j; i++) {
                res[i][n - j - 1] = num++;
            }
            for (int i = n - j - 2; i >= j; i--) {
                res[n - j - 1][i] = num++;
            }
            for (int i = n - j - 2; i > j; i--) {
                res[i][j] = num++;
            }
            j++;
        }
        return res; 
    }
}
