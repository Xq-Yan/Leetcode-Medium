/*
93. Restore IP Addresses

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
*/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (len < 4 || len > 12) return res;
        for (int i = 1; i <= 3; i++) {
            String sub1 = s.substring(0, i);
            if (i != 1 && sub1.charAt(0) == '0' || Integer.parseInt(sub1) > 255) break;
            for (int j = i + 1; j < i + 4 && j < len; j++) {
                String sub2 = s.substring(i, j);
                if (sub2.length() != 1 && sub2.charAt(0) == '0' || Integer.parseInt(sub2) > 255) break;
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String sub3 = s.substring(j, k);
                    if (sub3.length() != 1 && sub3.charAt(0) == '0' || Integer.parseInt(sub3) > 255) break;
                    String sub4 = s.substring(k);
                    if (sub4.length() != 1 && sub4.charAt(0) == '0' || Integer.parseInt(sub4) > 255) continue;
                    res.add(sub1 + "." + sub2 + "." + sub3 + "." + sub4);
                }
            }
        }
        return res;
    }
}
