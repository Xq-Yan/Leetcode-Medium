/*
91. Decode Ways

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
*/

class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
        int len = s.length();
        int[] dp = {1, 1, 0};
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != '0') dp[2] = dp[1];
            int num = 10 * (s.charAt(i - 1) - '0') + (s.charAt(i) - '0');
            if (num >= 10 && num <= 26) {
                dp[2] += dp[0];
            }
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = 0;
        }
        return dp[1];
    }
}
