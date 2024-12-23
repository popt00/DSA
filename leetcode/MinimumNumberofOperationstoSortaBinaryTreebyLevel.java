//https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/
class Solution {
    ArrayList<ArrayList<Integer>> ar;
    public int minimumOperations(TreeNode root) {
        ar=new ArrayList<>();
        putInAr(root,0);
        int ans=0;
        for(ArrayList<Integer> a:ar){
            ans+=findSwap(a);
            System.out.println(ans+":"+a+","+findSwap(a));
        }
        return ans;
    }
    public int findSwap(ArrayList<Integer> arr){
        int n=arr.size();
        int[][] ar= new int[arr.size()][2];
        for(int i=0;i<n;i++){
            ar[i][0]=arr.get(i);
            ar[i][1]=i;
        }
        Arrays.sort(ar, new Comparator<>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0],b[0]);
            }  
        });
        boolean[] vis=new boolean[n];
        int swaps=0;
        for(int i=0;i<n;i++){
            if(vis[i] || ar[i][1]==i)continue;
            int cycle_swap=0,x=i;
            while(vis[x]==false){
                vis[x]=true;
                x=ar[x][1];
                cycle_swap++;
            }
            if(cycle_swap>1)swaps+=cycle_swap-1;
        }
        return swaps;
    }
    public void putInAr(TreeNode root, int height){
        if(root==null)return;
        if(ar.size()==height)ar.add(new ArrayList<>());
        ar.get(height).add(root.val);
        putInAr(root.left,height+1);
        putInAr(root.right,height+1);
    }
}
