//https://leetcode.com/problems/move-pieces-to-obtain-a-string/description/
class Solution {
    public boolean canChange(String start, String target) {
        int Lcount=0,Rcount=0,n=start.length(),is=0,it=0;
        while(is<n && it<n){
            // L_____R convert
            while(is<n && start.charAt(is)=='_'){
                is++;
            }
            while(it<n && target.charAt(it)=='_'){
                it++;
            }
            if(is==n && it==n)continue;
            if((is==n && it!=n) ||(is!=n && it==n))return false;
            if(start.charAt(is)!=target.charAt(it))return false;
            if(start.charAt(is)=='L' && is<it){
                return false;
            }
            if(start.charAt(is)=='R' && is>it){
                return false;
            }
            is++;it++;
        }
        while(is<n && start.charAt(is)=='_'){
            is++;
        }
        while(it<n && target.charAt(it)=='_'){
            it++;
        }
        // System.out.println(is+","+it);
        return is==n && it==n;
    }
}
