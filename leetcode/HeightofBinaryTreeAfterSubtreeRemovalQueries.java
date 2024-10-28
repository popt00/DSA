//https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/
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
class Solution {
    HashMap<Integer,Integer> heightMap;
    public int[] treeQueries(TreeNode root, int[] queries) {
        heightMap= new HashMap<>();
        int n = getNumberOfNodes(root);
        int[] index=new int[1];index[0]=1;
        int[] swapped=new int[n+1];
        setSwap(root, swapped, index);
        setMapHeight(root);
        int[] ans= new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]=getHeightAfterRemoval(root,swapped[queries[i]])-1;
        }
        return ans;
    }
    public int getNumberOfNodes(TreeNode root){
        if(root==null)return 0;
        return 1 + getNumberOfNodes(root.left)+getNumberOfNodes(root.right);
    }
    public void setSwap(TreeNode root, int[] swap, int[] index){
        if(root==null)return;
        setSwap(root.left,swap,index);
        swap[root.val]=index[0];
        root.val=index[0]++;
        setSwap(root.right,swap,index);
    }
    //sets map height
    public int setMapHeight(TreeNode root){
        if(root==null)return 0;
        int right=setMapHeight(root.right);
        int left=setMapHeight(root.left);
        int height = 1+Math.max(right,left);
        heightMap.put(root.val,height);
        return height;
    }
    
    public int getHeightAfterRemoval(TreeNode root, int val){
        if(root==null || root.val==val)return 0;
        int left=0,right=0;
        if(root.val<val){
            if(root.left!=null)left=heightMap.get(root.left.val);
            right=getHeightAfterRemoval(root.right,val);
        }
        else {
            if(root.right!=null)right=heightMap.get(root.right.val);
            left=getHeightAfterRemoval(root.left,val);
        }
        return Math.max(left,right)+1;
    }
}
