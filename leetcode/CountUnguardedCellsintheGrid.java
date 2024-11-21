//https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int cnt=m*n;
        int[][] dp=new int[m][n];
        //guard = 2, walls 3
        for(int [] ar: guards){
            dp[ar[0]][ar[1]]=2; 
            cnt--; 
        }
        for(int [] ar: walls){
            dp[ar[0]][ar[1]]=3; 
            cnt--; 
        }

        //Traversing the matrix array
        for(int[] ar: guards){
            int r=ar[0], c=ar[1];
            //right
            for(int j=c+1;j<n;j++){
                if(dp[r][j]==2 || dp[r][j]==3)break;
                if(dp[r][j]==0)cnt--;
                dp[r][j]=1;
            }
            //left
            for(int j=c-1;j>=0;j--){
                if(dp[r][j]==2 || dp[r][j]==3)break;
                if(dp[r][j]==0)cnt--;
                dp[r][j]=1;
            }
            //bottom
            for(int i=r+1;i<m;i++){
                if(dp[i][c]==2 || dp[i][c]==3)break;
                if(dp[i][c]==0)cnt--;
                dp[i][c]=1;
            }
            //top
            for(int i=r-1;i>=0;i--){
                if(dp[i][c]==2 || dp[i][c]==3)break;
                if(dp[i][c]==0)cnt--;
                dp[i][c]=1;
            }
        }
        return cnt;
    }
}
