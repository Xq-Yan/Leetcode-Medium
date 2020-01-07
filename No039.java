/*
39. Combination Sum

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        res = combinationSum(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, List<List<Integer>> res, List<Integer> curr, int i) {
        if (candidates.length == 0) return res;
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return res;
        }
        if (target < 0) return res;
        for (; i < candidates.length; i++) {
            curr.add(candidates[i]);
            res = combinationSum(candidates, target - candidates[i], res, curr, i);
            curr.remove(curr.size() - 1);
        }
        return res;
    }
}
