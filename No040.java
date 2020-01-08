/*
40. Combination Sum II

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        res = combinationSum2(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target, List<List<Integer>> res, List<Integer> curr, int j) {
        if (candidates.length == 0) return res;
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return res;
        }
        if (target < 0) return res;
        for (int i = j; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            curr.add(candidates[i]);
            res = combinationSum2(candidates, target - candidates[i], res, curr, i + 1);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) i++;
            curr.remove(curr.size() - 1);
        }
        return res;
    }
}
