/*
Given the roots of two binary trees root and subRoot, 
return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. 
The tree tree could also be considered as a subtree of itself.

Example 1:
Input: root = [1,2,3,4,5], subRoot = [2,4,5]
Output: true

Example 2:
Input: root = [1,2,3,4,5,null,null,6], subRoot = [2,4,5]
Output: false

Constraints:
0 <= The number of nodes in both trees <= 100.
-100 <= root.val, subRoot.val <= 100
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

class SubTreeOfOtherTree {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        boolean result = false;
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if(node.val == subRoot.val){
                result = isSame(node, subRoot);
                if (result)return result;
            }
            if(node.left != null)st.push(node.left);
            if(node.right != null)st.push(node.right);
        }
        return result;
    }
  
    // recursive version of above 
    public boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || 
               isSubtree(root.right, subRoot);
    }
  
    private boolean isSame(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null)return true;
        if(r1 == null || r2 == null)return false;
        if(r1.val != r2.val)return false;
        return isSame(r1.left, r2.left) && isSame(r1.right, r2.right);
    }
}
