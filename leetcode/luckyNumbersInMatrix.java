/*
* https://leetcode.com/problems/lucky-numbers-in-a-matrix/
*/
class Solution {
    public List<Integer> luckyNumbers (int[][] mat) {
        List<Integer> ans=new ArrayList<>();
        int m=mat.length,n=mat[0].length;
        outer: for(int i=0;i<m;i++){
            int minIndex= 0;
            for(int j=0;j<n;j++){
                if(mat[i][j]<mat[i][minIndex])minIndex=j;
            }
            for(int k=0;k<m;k++){
                if(mat[k][minIndex]>mat[i][minIndex])continue outer;
            }
            ans.add(mat[i][minIndex]);
        }
        return ans;
        
    }
}
