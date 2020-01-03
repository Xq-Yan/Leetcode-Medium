/*
6.ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
*/

class Solution {
    public String convert(String s, int numRows) {
      if (s.length() == 0 || numRows <= 1) return s;
        String res = "";
        int i = 0;
        int flag = -1;
        String[] strs = new String[numRows];
        for (int j = 0; j < strs.length; j++) {
            strs[j] = new String();
        }
        for (char c : s.toCharArray()) {
            strs[i] += c;
            if (i == 0 || i + 1 == numRows) flag *= -1;
            i += flag;
        }
        for (String str : strs) {
            res += str;
        }
        return res;   
    }
}
