/*
* https://leetcode.com/problems/sort-the-jumbled-numbers/
*/
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] ak = convert(mapping, nums);
        int n=nums.length;
        Integer[] index=new Integer[n];
        for(int i=0;i<n;i++)index[i]=i;
        Arrays.sort(index,new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return Integer.compare(ak[a],ak[b]);
            }
        });
        
        int[] ans=new int[n];
        for(int i=0;i<n;i++)ans[i]=nums[index[i]];
        return ans;
    }
    public int[] convert(int[] map, int[] nums){
        int n=nums.length;
        int[] ak = new int[n];
        for(int i=0;i<n;i++){
            ak[i]=convert(map,nums[i]);
        }
        return ak;
    }
    public int convert(int[] map, int x){
        int y=0, mul=1;
        do{
            y+=map[x%10]*mul;
            x/=10;
            mul*=10;
        }while(x!=0);
        return y;
    }
}
