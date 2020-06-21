/*
62. Unique Paths
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

 

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28
*/

class Solution {
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        return (int) (multi(m, m + n - 2) / multi(1, n - 1));
    }

    private static long multi(int start, int end) {
        long fac = 1;
        for (int i = start; i <= end; i++) {
            fac *= i;
        }
        return fac;
    }
}
