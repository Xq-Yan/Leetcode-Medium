/*
43. Multiply Strings

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0) return num2;
        if (num2.length() == 0) return num1;
        if (num1.equals("0") || num2.equals("0")) return "0";
        int sum = 0;
        StringBuilder res = new StringBuilder();
        int[] temp = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                sum = (temp[i + j + 1] + n1 * n2);
                temp[i + j + 1] = sum % 10;
                temp[i + j] += sum / 10;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            if (i == 0 && temp[i] == 0) continue;
            res.append(temp[i]);
        }
        return res.toString();
    }
}
