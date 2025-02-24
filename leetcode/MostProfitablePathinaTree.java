//https://leetcode.com/problems/most-profitable-path-in-a-tree/description/
class Solution {
    HashMap<Integer,Integer> bobPath;
    ArrayList<ArrayList<Integer>> gr;
    boolean [] vis;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        gr= new ArrayList<>();
        int n= edges.length+1;
        for(int i=0;i<n;i++)gr.add(new ArrayList<>());
        for(int[] edge: edges){
            gr.get(edge[0]).add(edge[1]);
            gr.get(edge[1]).add(edge[0]);
        }
        bobPath= new HashMap<>();
        vis= new boolean[n];
        findBob(bob, 0);
        //System.out.println(bobPath);
        for(int i=0;i<n;i++)vis[i]=false;
        return dfs(0,0, amount); //curNode, time, amount
    }
    public int dfs(int curNode, int time,int[] amount){
        vis[curNode]=true;
        int curMax=Integer.MIN_VALUE;
        
        for(int i: gr.get(curNode)){
            if(!vis[i]){
                //System.out.println(curNode + ", i: "+i+ ", "+curMax);
                curMax= Math.max(curMax, dfs(i,time+1,amount));
            }
        }
        if(curMax==Integer.MIN_VALUE)curMax=0;
        int bobTime=bobPath.getOrDefault(curNode,Integer.MAX_VALUE);
        int curGateAmount=amount[curNode];
        //System.out.println(curNode+", curmax: "+curMax+", curGateamount: "+curGateAmount);
        if(bobTime < time){
            curGateAmount=0;
        }
        else if(bobTime== time){
            curGateAmount/=2;
        }
        //System.out.println(curNode+", curmax: "+curMax+", curGateamount: "+curGateAmount);
        return curMax + curGateAmount;
    }
    public boolean findBob(int bob, int time){
        if(bob==0){
            bobPath.put(bob,time);
            return true;
        }
        vis[bob]=true;
        for(int i:gr.get(bob)){
            if(!vis[i]){
                if(findBob(i,time+1)){
                    bobPath.put(bob,time);
                    return true;
                }
            }
        }
        return false;
    }
}
