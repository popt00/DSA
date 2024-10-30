//https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries
class Solution {
    //  heightOfTree;
    // ArrayList<ArrayList<Integer>> levelAr;
    ArrayList<Max2> levelAr;
    HashMap<Integer,Integer> mapLevel;
    class Max2{
        int val;
        int hei;
        int secondhei;
        Max2(int val,int hei){this.val=val;this.hei=hei;}
        void add(int val,int heiadd){
            if(this.hei<heiadd){
                this.secondhei=this.hei;
                this.hei=heiadd;
                this.val=val;
            }
            else if(this.secondhei<heiadd){
                this.secondhei=heiadd;
            }
        }
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = getTotalNodesNumber(root);
        levelAr=new ArrayList<>();
        mapLevel= new HashMap<>();
        int heightOfTree = fillHeights(root,0)-1;
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int q=queries[i];
            int level= mapLevel.get(q);
            if(levelAr.get(level).val==q){
                ans[i]=level+levelAr.get(level).secondhei-1;
            }
            else ans[i]=heightOfTree;
            
        }
       return ans;
    }
    public int getTotalNodesNumber(TreeNode root){
        if(root==null)return 0;
        return 1 + getTotalNodesNumber(root.left) + getTotalNodesNumber(root.right);
    }
    public int fillHeights(TreeNode root, int level){
        if(root==null)return 0;
        if(levelAr.size()<=level)levelAr.add(new Max2(0,0));
        int height = 1 + Math.max(
                                    fillHeights(root.left, level+1),
                                    fillHeights(root.right, level+1)
                                );
        
        levelAr.get(level).add(root.val,height);
        mapLevel.put(root.val,level);
        return height;
    }
}
