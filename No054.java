/*
54. Spiral Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        while (u <= d && l <= r) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[u][i]);
            }
            u++;
            for (int i = u; i <= d; i++) {
                res.add(matrix[i][r]);
            }
            r--;
            for (int i = r; i >= l && u <= d; i--) {
                res.add(matrix[d][i]);
            }
            d--;
            for (int i = d; i >= u && l <= r; i--) {
                res.add(matrix[i][l]);
            }
            l++;
        }
        return res;
    }
}
