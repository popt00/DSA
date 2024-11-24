//https://leetcode.com/problems/maximum-matrix-sum/description/
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ans= 0;
        int minimumMod=Integer.MAX_VALUE;
        boolean isEvenNegative=true;
        for(int[] ar: matrix){
            for(int x: ar){
                if(x<=0){
                    isEvenNegative=!isEvenNegative;
                }
                if(x<0)x=-x;
                ans+=x;
                minimumMod=Math.min(minimumMod,x);
            }
        }
        if(!isEvenNegative){
            ans-= 2*minimumMod;
        }
        return ans;
    }
}
