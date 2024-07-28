/*
* https://leetcode.com/problems/check-if-the-rectangle-corner-is-reachable/
*/class Solution {
    ArrayList<ArrayList<Integer>> graph;
    public boolean canReachCorner(int X, int Y, int[][] circles) {
        int n= circles.length;
        int[] dp= new int[n];
        ArrayList<Integer>x=new ArrayList<>();
        ArrayList<Integer>y=new ArrayList<>();
        graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
            if(isTouchingXAxis(circles[i], X)){
                dp[i]=1;
                x.add(i);
            }
            if(isTouchingYAxis(circles[i], Y)){
                if(dp[i]==1)return false;
                y.add(i);
                dp[i]=-1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isTouching(circles[i],circles[j])){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        boolean vis[]=new boolean[n];
        for(Integer c:x){
            if(traverse(dp,c,vis,1))return false;
        }
        for(Integer c:y){
            if(traverse(dp,c,vis,-1))return false;
        }
        return true;
    }
    public boolean inside(int [] c, int x, int y){
        long disSq = 1l*(c[0]-x)*(c[0]-x) + 1l*(c[1]-y)*(c[1]-y);
        long radiusSq= 1l*(1l*c[2])*(1l*c[2]);
        return disSq<=radiusSq;
    }
    public boolean traverse(int[] dp, int c,boolean[] vis, int val){
        if(vis[c])return false;
        vis[c]=true;
        for(Integer x: graph.get(c)){
            if(dp[x]==-val)return true;
            dp[x]=val;
            if(traverse(dp,x,vis,val))return true;
        }
        return false;
    }
    public boolean isTouching(int [] c1, int[] c2){
        long disSq = 1l*(c1[0]-c2[0])*(c1[0]-c2[0]) + 1l*(c1[1]-c2[1])*(c1[1]-c2[1]);
        long radiusSq= 1l*(1l*c1[2]+c2[2])*(1l*c1[2]+c2[2]);
        return disSq<=radiusSq;
    }
    public boolean isTouchingXAxis(int[] c, int x){
        return c[1]<=c[2] || Math.abs(x-c[0])<=c[2];
    }
    public boolean isTouchingYAxis(int[] c, int y){
        return c[0]<=c[2] || Math.abs(y-c[1])<=c[2];
    }
}
