/*
You are given two integer arrays preorder and inorder.
preorder is the preorder traversal of a binary tree
inorder is the inorder traversal of the same tree
Both arrays are of the same size and consist of unique values.
Rebuild the binary tree from the preorder and inorder traversals and return its root.

Example 1:
Input: preorder = [1,2,3,4], inorder = [2,1,3,4]
Output: [1,2,3,null,null,null,4]

Example 2:
Input: preorder = [1], inorder = [1]
Output: [1]

Constraints:
1 <= inorder.length <= 1000.
inorder.length == preorder.length
-1000 <= preorder[i], inorder[i] <= 1000
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

class constructTreeFromInorderAndPreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int mid = -1;
        for(int i=0;i<inorder.length;i++) {
            if(preorder[0] == inorder[i]){
                mid = i;
                break;
            }
        }

        int[] leftPre = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree(leftPre, leftIn);

        int[] rightPre = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] rightIn = Arrays.copyOfRange(inorder, mid+1, inorder.length);
        root.right = buildTree(rightPre, rightIn);

        return root;
    }
}
