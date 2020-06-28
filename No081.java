/*
81. Search in Rotated Sorted Array II

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
*/

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        if (nums.length == 1) return nums[0] == target;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return true;
            if (nums[l] == nums[m]) {
                l++;
                continue;
            }
            if (nums[l] < nums[m]) {
                if (nums[m] > target && nums[l] <= target) {
                    r = m - 1;
                } else l = m + 1;
            } else {
                if (nums[m] < target && nums[r] >= target) {
                    l = m + 1;
                } else r = m - 1;
            }

        }
        return false;
    }
}
