//https://leetcode.com/problems/cousins-in-binary-tree/
class Solution {
    class TreeNodeInfo{
        TreeNode parent;
        int height;
        TreeNodeInfo(int h){height=h;}
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNodeInfo xInfo = getInfo(root,x,0);
        TreeNodeInfo yInfo = getInfo(root,y,0);
        return xInfo.parent!=yInfo.parent && xInfo.height==yInfo.height;
    }
    public TreeNodeInfo getInfo(TreeNode root,int x, int height){
        if(root==null)return null;
        if(root.val==x)return new TreeNodeInfo(height);
        TreeNodeInfo info=getInfo(root.left,x,height+1);
        if(info!=null){
            if(info.parent==null)info.parent=root;
            return info;
        }
        info=getInfo(root.right,x,height+1);
        if(info!=null){
            if(info.parent==null)info.parent=root;
            return info;
        }
        return null;
    }
}
