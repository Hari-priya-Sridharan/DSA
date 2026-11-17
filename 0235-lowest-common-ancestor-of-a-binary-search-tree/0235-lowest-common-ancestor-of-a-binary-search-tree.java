/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        if(cur==null) return null;
        if(p.val<cur.val && q.val<cur.val) return lowestCommonAncestor(cur.left,p,q);
        else if(p.val>cur.val && q.val>cur.val) return lowestCommonAncestor(cur.right,p,q);
        else return cur; 
    }
}