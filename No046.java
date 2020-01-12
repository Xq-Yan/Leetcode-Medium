/*
46. Permutations

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res = permute(nums, res, new ArrayList<>());
        return res;
    }

    public List<List<Integer>> permute(int[] nums, List<List<Integer>> res, ArrayList<Integer> curr) {
        if (nums.length == 0) return res;
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i])) continue;
            curr.add(nums[i]);
            res = permute(nums, res, curr);
            curr.remove(curr.size() - 1);
        }
        return res;
    }
}
