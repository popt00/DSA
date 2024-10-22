//https://leetcode.com/problems/dungeon-game/
class Solution {
    public int calculateMinimumHP(int[][] d) {
        int i=1,j=1000*201;
        while(i+1<j){
            int m =(i+j)/2;
            if(canClear(d,m))j=m;
            else i=m;
            // System.out.println(i+","+j);
        }
        if(canClear(d,i))return i;
        return j;
    }
    public boolean canClear(int[][] ar, int val){
        int m=ar.length,n=ar[0].length;
        int[][] path= new int[m][n];
        path[0][0]=val+ar[0][0];
        if(path[0][0]<=0)return false;
        for(int i=1;i<m;i++){
            path[i][0]=path[i-1][0]+ar[i][0];
            if(path[i][0]<=0)break;
        }
        for(int j=1;j<n;j++){
            path[0][j]=path[0][j-1]+ar[0][j];
            if(path[0][j]<=0)break;
        }
        for(int i=1;i<m;i++){
            inner: for(int j=1;j<n;j++){
                if(path[i-1][j]>0 || path[i][j-1]>0){
                    path[i][j]=Math.max(path[i-1][j],path[i][j-1])+ar[i][j];
                }
            }
        }
        // System.out.println(val);
        // for(int i=0;i<m;i++)System.out.println(Arrays.toString(path[i]));
        return path[m-1][n-1]>0;
    }
}
