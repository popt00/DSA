//https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] ar=new int[(n*n+n)/2];
        int index=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                ar[index++]=sum;
            }
        }
        Arrays.sort(ar);
        long ans=0;
        for(int i=left-1;i<right;i++){
            ans+=ar[i];
        }
        return (int)(ans%1000000007);
    }
}
