class Solution {
    public void sortColors(int[] nums) {
        int zero=0,j=nums.length-1;
        for(int i=0;i<=j;){
            if(nums[i]==1){
                i++;
            }
            else if(nums[i]==0){
                nums[i]=nums[zero];
                nums[zero]=0;
                zero++;
                i++;
            }
            else if(nums[i]==2){
                nums[i]=nums[j];
                nums[j]=2;
                j--;
            }
        }
    }
}
