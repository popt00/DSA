//https://leetcode.com/problems/wildcard-matching/description/
class Solution {
    // String S;String P;
    public boolean isMatch(String s, String p) {
        // S=s;P=p;
        int stS=0,edS=s.length()-1;
        int stP=0,edP=p.length()-1;
        while(stP<=edP && stS<=edS && p.charAt(stP)!='*'){
            if(!match(s,p,stS,stP))return false;
            stP++;stS++;
        }
        while(stP<=edP && stS<=edS && p.charAt(edP)!='*'){
            if(!match(s,p,edS,edP))return false;
            edP--;edS--;
        }
        //if there is no * then check and return
        if(stP==edP+1){
            return stS==edS+1;
        }
        A: while(stP<=edP && stS<=edS){
            while(stP<=edP && p.charAt(stP)=='*')stP++;
            int startindex=stP;
            while(stP<=edP && p.charAt(stP)!='*')stP++;
            String innerP= p.substring(startindex,stP);
            if(innerP.length()==0)continue;
            System.out.println(innerP);
            //stS...edS find innerP
            for(int j=stS;j<=edS;j++){
                int k=0;
                innerLoop: for(;k<innerP.length() && j+k<=edS;k++){
                    // System.out.print(s.charAt(j+k));
                    if(!match(s,innerP,j+k,k))break innerLoop;
                }
                // System.out.println("");
                if(k==innerP.length()){
                    stS=j+k;
                    continue A;
                }
            }
            // System.out.print("inner false");
            return false;
        }
        // at end if there is all * then pass it
        while(stP<=edP && p.charAt(stP)=='*')stP++;
        // System.out.print(stP+","+edP+"last false");
        return stP==edP+1;
    }
    public boolean match(String S, String P, int st_s, int st_p){
        if(P.charAt(st_p)=='?')return true;
        return S.charAt(st_s)==P.charAt(st_p);
    }
}
