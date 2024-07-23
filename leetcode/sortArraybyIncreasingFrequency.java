/*
* https://leetcode.com/problems/sort-array-by-increasing-frequency/
*/
class Solution {
    public int[] frequencySort(int[] nums) {
        for(int i=0;i<nums.length;i++)nums[i]+=100;
        int[] freq=new int[202];
        for(int x:nums)freq[x]++;
        Integer[] indexAr=new Integer[nums.length];
        for(int i=0;i<nums.length;i++)indexAr[i]=i;
        Arrays.sort(indexAr, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                if(freq[nums[a]]==freq[nums[b]])return Integer.compare(nums[b],nums[a]);
                return Integer.compare(freq[nums[a]],freq[nums[b]]);
            }
        });
        int [] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++)ans[i]=nums[indexAr[i]]-100;
        return ans;
    }
}
