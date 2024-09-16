//https://leetcode.com/problems/minimum-time-difference
class Solution {
    public int findMinDifference(List<String> timePoints) {
        String[] stAr=new String[timePoints.size()];
        int i=0;
        for(String str: timePoints){stAr[i++]=str;}
        Arrays.sort(stAr);//sorting array from 00 to 23:59
        return findMinDiffSorted(stAr);
    }
    public int findMinDiffSorted(String[] ar){
        int n=ar.length,minDiff=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            minDiff=Math.min(findDiff(ar[i-1],ar[i]),minDiff);
        }
        minDiff=Math.min(findDiff(ar[n-1],ar[0]),minDiff);
        return minDiff;
    }
    // finds difference between 2 strings
    public int findDiff(String stra, String strb){
        int diff = getMinutes(strb)-getMinutes(stra);
        if(diff<0)diff+=24*60; // if a>b then we will add 24 hours
        // System.out.println(diff);
        
        return diff;
    }
    public int getMinutes(String A){
        return Integer.parseInt(A.substring(0,2))*60+Integer.parseInt(A.substring(3,5));
    }
}
