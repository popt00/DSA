class Solution {
    List<List<Integer>> ans;
    List<Integer> curr;
    int[] arr;
    boolean[] vis;
    int n;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        curr = new ArrayList<>();
        arr=nums;
        n=nums.length;
        vis= new boolean[n];
        recur();
        return ans;
    }
    public void recur(){
        if(curr.size()==n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                vis[i]=true;
                curr.add(arr[i]);
                recur();
                vis[i]=false;
                curr.removeLast();
            }
        }
    }

}
