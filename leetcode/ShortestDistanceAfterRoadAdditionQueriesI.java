//https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/description/
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] ans= new int[queries.length];
        ArrayList<ArrayList<Integer>> child= new ArrayList<>();
        for(int i=0;i<n;i++){
            child.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++)child.get(i).add(i+1);
        for(int i=0;i<queries.length;i++){
            child.get(queries[i][0]).add(queries[i][1]);
            ans[i]=bfs(child,0,n-1);
        }
        return ans;
    }
    public int bfs(ArrayList<ArrayList<Integer>> ar, int st, int n){
        int i=0;
        boolean[] vis= new boolean[n+1];
        int[] path= new int[n+1];
        path[0]=0;
        LinkedList<Integer> list= new LinkedList<>();
        list.add(st);
        vis[st]=true;
        outer: while(true){
            int curr=list.removeFirst();
            int currPath= path[curr];
            for(Integer c: ar.get(curr)){
                if(!vis[c]){
                    vis[c]=true;
                    path[c]=currPath+1;
                    if(c==n)break outer;
                    list.add(c);
                }
            }
        }
        return path[n];
    }
}
