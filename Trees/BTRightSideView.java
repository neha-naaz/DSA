/*
You are given the root of a binary tree. 
Return only the values of the nodes that are visible from the right side of the tree, ordered from top to bottom.

Example 1:
Input: root = [1,2,3]
Output: [1,3]

Example 2:
Input: root = [1,2,3,4,5,6,7]
Output: [1,3,7]

Constraints:
0 <= number of nodes in the tree <= 100
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

class BTRightSideView {
    // Level Order Traversal, addking only the last nodes of the level to result
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)return result;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            int len = que.size();
            TreeNode node = null;
            for(int i=0;i<len;i++) {
                node = que.poll();
                if(node.left != null) {
                    que.offer(node.left);
                }
                if(node.right != null) {
                    que.offer(node.right);
                }
            }
            if(node != null)result.add(node.val);
        }

        return result;
    }
}
