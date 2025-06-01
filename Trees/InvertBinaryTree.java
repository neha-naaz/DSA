/*
You are given the root of a binary tree root. Invert the binary tree and return its root.

Example 1:
Input: root = [1,2,3,4,5,6,7]
Output: [1,3,2,7,6,5,4]

Example 2:
Input: root = [3,2,1]
Output: [3,1,2]

Example 3:
Input: root = []
Output: []

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

class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                que.offer(node.left);
            }

            if (node.right != null) {
                que.offer(node.right);
            }
        }
        return root;
    }
}

