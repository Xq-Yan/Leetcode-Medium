/*
5.Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

class Solution {
    public String longestPalindrome(String s) {
      if (s.length() < 2) return s;
        int max = 0;
        String res = "" + s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            int k = 1;
            while (i - k >= 0 && i + k < s.length() && s.charAt(i - k) == s.charAt(i + k)) {
                k++;
            }
            if (2 * k - 1 > res.length()) {
                res = s.substring(i - (k - 1), i + (k - 1) + 1);
            }
            k = 1;
            while (i - k + 1 >= 0 && i + k < s.length() && s.charAt(i - k + 1) == s.charAt(i + k)) {
                k++;
            }
            if (2 * k - 2 > res.length()) {
                res = s.substring(i - (k - 1) + 1, i + (k - 1) + 1);
            }
        }
        return res;
    }
}
