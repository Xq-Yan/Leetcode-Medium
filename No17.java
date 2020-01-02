/*
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()){
            return res;
        }
        letterCombinations(digits, res, "");
        return res;
    }

    public static List<String> letterCombinations(String digits, List<String> res, String curr) {
        if (digits.isEmpty()) {
            res.add(curr);
            return res;
        }
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int num = digits.charAt(0) - '0';
        for (char ch : letters[num].toCharArray()) {
            res = letterCombinations(digits.substring(1), res, curr + ch);
        }
        return res;
    }
}
