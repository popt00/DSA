class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int x: nums)set.add(x);
        int ans=(nums.length==0)?0:1;
        for(int x: set){
            if(!set.contains(x-1)){
                //it means start of sequence
                int len=0,curr=x;
                while(set.contains(curr)){
                    len++;curr++;
                }
                ans=Math.max(len,ans);
            }
        }
        return ans;
    }
}
