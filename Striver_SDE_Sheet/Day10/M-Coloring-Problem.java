class Solution {
    int[] dp;
    ArrayList<ArrayList<Integer>> adj;
    int maxColor;
    boolean graphColoring(int v, List<int[]> edges, int m) {
        // code here
        maxColor=m;
        dp=new int[v];
        Arrays.fill(dp,-1);
        adj=new ArrayList<>();
        for(int i=0;i<v;i++)adj.add(new ArrayList<>());
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<v;i++){
            if(dp[i]==-1){
                dp[i]=1;
                if(!fillColor(i)){
                    return false;
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return true;
    }
    
    boolean fillColor(int i){
        for(Integer x: adj.get(i)){
            if(dp[x]==-1){
                for(int val=1;val<=maxColor;val++){
                    if(check(x,val)){
                        dp[x]=val;
                        if(!fillColor(x))dp[x]=-1;
                    }
                }
                if(dp[x]==-1)return false;
            }
        }
        return true;
    }
    
    boolean check(int i, int val){
        for(Integer x: adj.get(i)){
            if(dp[x]==val)return false;
        }
        return true;
    }
    
    
    int findMax(int[] dp){
        int max=dp[0];
        for(int x:dp){
            max=Math.max(x,max);
        }
        return max;
    }
}
