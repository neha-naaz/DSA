/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 
Constraints:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
*/

class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, l, res, candidates, target);

        return res;
    }

    private void helper(int ind, List<Integer> l, List<List<Integer>> res, int[] arr, int target) {
        if(target == 0){
            res.add(new ArrayList<>(l));
            return;
        }

        for(int i=ind;i<arr.length;i++){
            if(i > ind && arr[i] == arr[i-1])continue;
            if(arr[i] > target)break;

            l.add(arr[i]);
            helper(i+1, l, res, arr, target-arr[i]);
            l.remove(l.size()-1);
        }
    }
}
