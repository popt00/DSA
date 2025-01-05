//https://leetcode.com/problems/symmetric-tree/description/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.right, root.left);
    }
    public boolean helper(TreeNode a, TreeNode b){
        if(a==null && b==null)return true;
        if(a!=null && b!=null){
            if(a.val!=b.val)return false;
            return helper(a.left,b.right) && helper(a.right,b.left);
        }
        return false;
    }
}
