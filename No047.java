/*
47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        res = permuteUnique(list, res, new ArrayList<>());
        return res;
    }

    public List<List<Integer>> permuteUnique(List<Integer> nums, List<List<Integer>> res, List<Integer> curr) {
        if (nums.isEmpty()) {
            res.add(new ArrayList<>(curr));
            return res;
        }
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (i > 0 && num == nums.get(i - 1)) continue;
            curr.add(num);
            nums.remove(i);
            res = permuteUnique(nums, res, curr);
            curr.remove(curr.size() - 1);
            nums.add(i, num);
        }
        return res;
    }
}
