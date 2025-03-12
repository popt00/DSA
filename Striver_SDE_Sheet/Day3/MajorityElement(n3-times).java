class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int maj1=0,maj2=0;
        int ele1=0,ele2=1;
        for(int x:nums){
            if(ele1==x)maj1++;
            else if(ele2==x)maj2++;
            else if(maj1==0){
                maj1=1;ele1=x;
            }
            else if(maj2==0){
                maj2=1;ele2=x;
            }
            else{
                maj1--;maj2--;
            }
        }
        maj1=count(nums,ele1);
        maj2=count(nums,ele2);
        int comparatorValue=nums.length/3;
        if(maj1>comparatorValue && maj2>comparatorValue && ele1!=ele2)return Arrays.asList(ele1,ele2);
        if(maj1>comparatorValue)return Arrays.asList(ele1);
        if(maj2>comparatorValue)return Arrays.asList(ele2);
        return Arrays.asList();
    }
    public int count(int[] arr, int n){
        int count=0;
        for(int x: arr){
            if(x==n)count++;
        }
        return count;
    }
}
