//https://leetcode.com/problems/subsets/
class Solution {
    List<List<Integer>> ans;
    LinkedList<Integer> curr;
    public List<List<Integer>> subsets(int[] nums) {
        ans= new LinkedList<>();
        curr= new LinkedList<>();
        backtrack(nums,0);
        return ans;
    }
    public void backtrack(int[] nums, int i){
        ans.add((LinkedList)curr.clone());
        while(i<nums.length){
            curr.add(nums[i]);
            backtrack(nums,i+1);
            curr.removeLast();
            i++;
        }
    }
}
