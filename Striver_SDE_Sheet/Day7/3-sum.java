class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        ans=new ArrayList<>();
        for(int i=0;i<n;){
            twoSum(i+1,-nums[i],nums);
            int val=nums[i];
            while(i<n&& nums[i]==val)i++;
        }
        return ans;
    }
    private void twoSum(int st, int val, int[] nums){
        int ed=nums.length-1;
        while(st<ed){
            if(nums[st]+nums[ed]>val){
                ed--;
            }
            else if(nums[st]+nums[ed]<val){
                st++;
            }
            else{
                ans.add(Arrays.asList(-val,nums[st],nums[ed]));
                st++;
                ed--;
                while(st<ed && nums[st-1]==nums[st])st++;
                while(st<ed && nums[ed]==nums[ed+1])ed--;
            }
        }
    }
}
