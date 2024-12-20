//https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/
class Solution {
    ArrayList<ArrayList<Integer>> memo;
    ArrayList<Integer> index;
    public TreeNode reverseOddLevels(TreeNode root) {
        memo=new ArrayList<>();
        index=new ArrayList<>();
        traverse(root,0);
        reverse(root,0);
        return root;
    }
    public void traverse(TreeNode root, int level){
        if(root==null)return;
        if(memo.size()<=level){memo.add(new ArrayList<>());index.add(0);}
        memo.get(level).add(root.val);
        traverse(root.left,level+1);
        traverse(root.right,level+1);
    }
    public void reverse(TreeNode root, int level){
        if(root==null)return;
        if(level%2==1){
            int i=index.get(level);
            root.val=memo.get(level).get(i);
            index.set(level,i+1);
        }
        reverse(root.right,level+1);
        reverse(root.left,level+1);
    }
}
