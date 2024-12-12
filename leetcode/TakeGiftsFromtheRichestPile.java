//https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/
class Solution {
    public long pickGifts(int[] gifts, int k) {
        while(k-->0){
            doProcess(gifts);
        }
        return sum(gifts);
    }
    public void doProcess(int[] gifts){
        int maxInd=0;
        for(int i=0;i<gifts.length;i++){
            if(gifts[maxInd]<gifts[i])maxInd=i;
        }
        gifts[maxInd]=(int)Math.sqrt(gifts[maxInd]);
    }
    public long sum(int[] ar){
        long sum=0;
        for(int x:ar){
            sum+=x;
        }
        return sum;
    }
}
