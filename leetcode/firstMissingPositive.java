/**
 * https://leetcode.com/problems/first-missing-positive/description/
 * intution: use array as hashing (storing boolean value in positive/negative )
 * here : negative means present in array, positive means not present
 * limitation: max integer present is array length
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        //check for one present
        int n=nums.length,i=0;
        while(i<n){
            if(nums[i]==1){break;}
            i++;
        }
        if(i==n)return 1;
        for(int j=0;j<n;j++){
            if(nums[j]<=0)nums[j]=1;
        }
        for(int j=0;j<n;j++){
            int x= Math.abs(nums[j])-1;
            //if  1 then it is 0 starting with in array
            if(x<n && nums[x]>0)nums[x]=0-nums[x];
        }
        i=0;
        while(i<n && nums[i]<0){
            //check for first positive
            i++;
        }
        return i+1;
        

    }
    void print(int []ar){
        for(int i=0;i<ar.length;i++)System.out.print(ar[i]+",");
        System.out.println("");
    }
}