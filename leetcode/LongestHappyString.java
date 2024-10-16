//https://leetcode.com/problems/longest-happy-string/description/
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // if(a<=b && a<=c)return makeString(a,'a',b,'b',c,'c');
        // if(a<=b && a<=c)return makeString(a,'a',b,'b',c,'c');
        StringBuilder sb= new StringBuilder();
        int n=a+b+c;
        //first phase, remove minimum
        while(a>0 && b>0 && c>0){
            sb.append("abc");
            a--;b--;c--;
        }
        // second phase, remove second minimum
        if(a==0){
            while(b>0&&c>0){
                sb.append("bc");
                b--;c--;
            }
        }
        else if(b==0){
            while(a>0&&c>0){
                sb.append("ac");
                a--;c--;
            }
        }
        else if(c==0){
            while(a>0 && b>0){
                sb.append("ab");
                a--;b--;
            }
        }
        // remaining one
        if(a!=0){
            insertBetween(a,'a',sb);
        }
        if(b!=0){
            insertBetween(b,'b',sb);
        }
        if(c!=0){
            insertBetween(c,'c',sb);
        }
        //return string answer
        return sb.toString();
    }
    public void insertBetween(int a, char A, StringBuilder sb){
        int i=0;
        int countA=0;
        while(a>0 && i<sb.length()){
            if(sb.charAt(i)==A){
                countA++;
            }
            else{
                if(countA<2){
                    sb.insert(i,A);
                    a--;
                    countA++;
                }
                else{
                    countA=0;
                }
            }
            i++;
        }
        while(a>0 && countA<2){
            sb.insert(i,A);
            a--;
            countA++;
        }
    }
}
