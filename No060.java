/*
60. Permutation Sequence
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
*/

/*
class Solution {
     public String getPermutation(int n, int k) {
        String res = "";
        k--;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        int fac = 1;
        for (int i = 1; i < n; i++) {
            fac *= i;
        }
        while (n != 1) {
            int idx = k / fac;
            k %= fac;
            res += list.remove(idx);
            n--;
            fac /= n;
        }
        res += list.remove(0);
        return res;
    }
}
*/

class Solution {
     public String getPermutation(int n, int k) {
        String res = "";
        k--;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        res = solve(n, k, list, res);
        return res;
    }

    private String solve(int n, int k, List<Integer> list, String res) {
        if(n == 1){
            res += list.remove(0);
            return res;
        }
        int fac = 1;
        for (int i = 1; i < n; i++) {
            fac *= i;
        }
        int idx = k / fac;
        res += list.remove(idx);
        res = solve(n - 1, k % fac, list, res);
        return res;
    }
}
