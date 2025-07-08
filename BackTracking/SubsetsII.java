/*
You are given an array nums of integers, which may contain duplicates. Return all possible subsets.

The solution must not contain duplicate subsets. You may return the solution in any order.

Example 1:

Input: nums = [1,2,1]

Output: [[],[1],[1,2],[1,1],[1,2,1],[2]]
Example 2:

Input: nums = [7,7]

Output: [[],[7], [7,7]]
Constraints:

1 <= nums.length <= 11
-20 <= nums[i] <= 20

*/

class SubsetsII {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] arr, int ind, List<Integer> l) {
        res.add(new ArrayList<>(l));

        for(int i=ind;i<arr.length;i++){
            if(i > ind && arr[i] == arr[i-1])continue;

            l.add(arr[i]);
            helper(arr, i+1, l);
            l.remove(l.size()-1);
        }
    }
}
