/*
Maximum Depth of Binary Tree

Given the root of a binary tree, return its depth.
The depth of a binary tree is defined as the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:
Input: root = [1,2,3,null,null,4]
Output: 3

Example 2:
Input: root = []
Output: 0

Constraints:
0 <= The number of nodes in the tree <= 100.
-100 <= Node.val <= 100
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

class MaxDepthOfBT {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lDepth = 1 + maxDepth(root.left);
        int rDepth = 1 + maxDepth(root.right);

        return Math.max(lDepth, rDepth);
    }
  
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);

        if(lDepth > rDepth) {
            return lDepth+1;
        }
        return rDepth+1;
    }
}
