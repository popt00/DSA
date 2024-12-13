//https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description/
class Solution {
    public long findScore(int[] nums) {
        int n=nums.length;
        int[][] ar=new int[n][2];
        for(int i=0;i<n;i++){
            ar[i][0]=nums[i];
            ar[i][1]=i;
        }
        Arrays.sort(ar, new Comparator<>(){
            public int compare(int[] a, int [] b){
                if(a[0]!=b[0])return Integer.compare(a[0],b[0]);
                return Integer.compare(a[1],b[1]);
            }
        });
        long score=0;
        for(int[] indexAr: ar){
            int index=indexAr[1];
            if(nums[index]>0){
                score+=nums[index];
                if(index>0 &&nums[index-1]>0) nums[index-1]=0-nums[index-1];
                if(index+1<n &&nums[index+1]>0) nums[index+1]=0-nums[index+1];
            }
        }
        return score;
    }
}
