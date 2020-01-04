/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        res = generate(n, n, res, "");
        return res;
    }

    public static List<String> generate(int l, int r, List<String> res, String curr) {
        if (l + r == 0) {
            res.add(curr);
            return res;
        }
        if (l > 0) res = generate(l - 1, r, res, curr + "(");
        if (l < r) res = generate(l, r - 1, res, curr + ")");
        return res;
    }
}
