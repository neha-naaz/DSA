/*
Given an array nums of unique integers, return all the possible permutations. You may return the answer in any order.

Example 1:

Input: nums = [1,2,3]

Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [7]

Output: [[7]]
Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10

*/

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    private void helper (int[] nums, List<Integer> curr, boolean[] seen, List<List<Integer>> res) {
        if (curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i=0;i<nums.length;i++) {
            if (!seen[i]) {
                curr.add(nums[i]);
                seen[i] = true;
                helper(nums, curr, seen, res);
                curr.remove(curr.size()-1);
                seen[i] = false;
            }
        }
    }
}

