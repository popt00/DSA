//https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/
class Solution {
    public int largestCombination(int[] candidates) {
        int[] bits=new int[32];
        for(int x:candidates){
            for(int i=0;i<32;i++){
                if((x&(1<<i))!=0)bits[i]++;
            }
        }
        int ans=0;
        for(int bit:bits)ans=Math.max(bit,ans);
        return ans;
    }
}
