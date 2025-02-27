class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        while(i>0 && nums[i-1]>=nums[i])i--;
        if(i==0){
            reverse(nums,0,nums.length-1);
            return;
        }
        int pivot=i-1;
        int justGreaterThanPivot=pivot+1;
        for(int j=pivot+1;j<nums.length;j++){
            if(nums[j]>nums[pivot]){
                if(nums[justGreaterThanPivot]>=nums[j])
                    justGreaterThanPivot=j;
            }
        }
        swap(nums,pivot,justGreaterThanPivot);
        reverse(nums,pivot+1,nums.length-1);
    }
    public void reverse(int[] nums, int st, int ed){
        while(st<ed){
            swap(nums,st,ed);
            st++;ed--;
        }
    }
    public void swap(int[] nums,int i, int j){
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
