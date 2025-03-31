class Solution {
    private List<List<Integer>> ans;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        ans= new ArrayList<>();
        for(int i=0;i<n;){
            for(int j=i+1;j<n;){
                twoSum(i,j,nums,1l*target-nums[i]-nums[j]);
                int k=nums[j];
                while(j<n && nums[j]==k)j++;
            }
            int k=nums[i];
            while(i<n && nums[i]==k)i++;
        }
        return ans;
    }
    public void twoSum(int a, int b, int[] nums, long target){
        int i=b+1,j=nums.length-1;
        while(i<j){
            long sum=1l*nums[i]+nums[j]-target;
            if(sum>0){
                j--;
            }
            else if(sum<0){
                i++;
            }
            else{
                ans.add(Arrays.asList(nums[a],nums[b],nums[i],nums[j]));
                int val=nums[i];
                while(i<j && nums[i]==val)i++;
            }
        }
    }
}
