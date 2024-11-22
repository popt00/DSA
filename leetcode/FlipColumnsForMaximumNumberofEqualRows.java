//https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ans=0;
        for(int i=0;i<matrix.length;i++){
            int[] row= matrix[i];
            int currMax=0;
            for(int ir=0;ir<matrix.length;ir++){
                if(isSameAfterFlip(matrix[ir],row))currMax++;
            }
            ans=Math.max(currMax,ans);
        }
        return ans;
    }
    public boolean isSameAfterFlip(int[] a,int[] b){
        boolean comp= (a[0]==b[0]);
        for(int i=1;i<a.length;i++){
            if(comp != (a[i]==b[i]))return false;
        }
        return true;
    }
}
