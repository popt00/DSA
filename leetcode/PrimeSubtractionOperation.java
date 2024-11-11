//https://leetcode.com/problems/prime-subtraction-operation/
class Solution {
    public boolean primeSubOperation(int[] nums) {
        boolean[] isprime= getIsPrime(1002);
        int pre=0;
        for(int i=0;i<nums.length;i++){
            int indexCurr=nums[i]-pre-1;
            while(indexCurr>0 && !isprime[indexCurr]){
                indexCurr--;
            }
            if(indexCurr>0 && isprime[indexCurr])nums[i]-=indexCurr;
            if(nums[i]<=pre)return false;
            pre=nums[i];
        }
        return true;
    }
    public boolean [] getIsPrime(int n){
        boolean [] isprime=new boolean[n];
        isprime[2]=true;
        for(int i=2;i<n;i++)isprime[i]=true;
        for(int i=2;i<n;i++){
            if(isprime[i]){
                for(int j=i+i;j<n;j+=i){
                    isprime[j]=false;
                }
            }
            
        }
        return isprime;
    }
}
