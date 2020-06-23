/*
77. Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

class Solution {
        List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        getList(list, 1, n, k);
        return res;
    }

    private void getList(List<Integer> list, int i, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            getList(list, j + 1, n, k - 1);
            list.remove(list.size()-1);
        }
    }
}
