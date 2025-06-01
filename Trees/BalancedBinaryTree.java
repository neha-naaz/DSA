/*
Balanced Binary Tree

Given a binary tree, return true if it is height-balanced and false otherwise.
A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:
Input: root = [1,2,3,null,null,4]
Output: true

Example 2:
Input: root = [1,2,3,null,null,4,null,5]
Output: false

Example 3:
Input: root = []
Output: true

Constraints:
The number of nodes in the tree is in the range [0, 1000].
-1000 <= Node.val <= 1000

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        // return first val of array(blanced or not)
        return dfs(root)[0] == 1;
    }
    private int[] dfs(TreeNode root) {
        if (root == null) {
            // first val denotes balance, second val height 
            return new int[]{1, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balanced = left[0] == 1 && right[0] == 1 &&
                            Math.abs(left[1] - right[1]) <= 1;
        
        int height = 1 + Math.max(left[1], right[1]);
        return new int[]{balanced ? 1 : 0, height};
    }
}
