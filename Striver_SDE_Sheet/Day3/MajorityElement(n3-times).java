class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int maj1=0,maj2=0;
        int ele1=0,ele2=0;
        for(int x:nums){
            if(maj1==0){maj1++; ele1=x;}
            else if(maj2==0){maj2++; ele2=x;}
            else if(ele1==x)maj1++;
            else if(ele2==x)maj2++;
            else {maj1--;maj2--;}
        }
        int comparatorValue=nums.length/3;
        if(maj1>comparatorValue && maj2>comparatorValue)return Arrays.asList(ele1,ele2);
        if(maj1>comparatorValue)return Arrays.asList(ele1);
        if(maj2>comparatorValue)return Arrays.asList(ele2);
        return Arrays.asList();
    }
}
