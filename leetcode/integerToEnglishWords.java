//https://leetcode.com/problems/integer-to-english-words/
class Solution {
    ArrayList <String> list;
    public String numberToWords(int num) {
        if(num==0)return "Zero";
        list = new ArrayList<>();
        long n= num*1l;
        String ans="";
        int hundreads=num%1000;
        int k = (int)((n%1000000)/1000);
        int m = (int)((n%1000000000)/1000000l);
        int b = (int)((n%1000000000000l)/1000000000l);
        // System.out.println(b+" "+m+" "+k+" "+hundreads);

        if(b!=0){convertToHundreads(b); list.add("Billion");}
        if(m!=0){convertToHundreads(m); list.add("Million");}
        if(k!=0){convertToHundreads(k); list.add("Thousand");}
        if(hundreads!=0){convertToHundreads(hundreads);}
        ans=list.get(0);
        list.remove(0);
        for(String x: list){
            ans = ans+" "+x;
        }
        return ans;
    }
    private void convertToHundreads(int n){
        int hund= n/100;
        int ones= n%10;
        int deci = (n%100)/10;
        if(hund!=0){convertToOnes(hund); list.add("Hundred");}
        if(deci==1){
            convertToTens(deci*10+ones);
        }
        else {
            if(deci != 0){convertToDeci(deci);}
            if(ones != 0){convertToOnes(ones);}
        }
    }
    private void convertToOnes(int n){
        if(n==1)list.add("One");
        if(n==2)list.add("Two");
        if(n==3)list.add("Three");
        if(n==4)list.add("Four");
        if(n==5)list.add("Five");
        if(n==6)list.add("Six");
        if(n==7)list.add("Seven");
        if(n==8)list.add("Eight");
        if(n==9)list.add("Nine");
    }
    private void convertToDeci(int n){
        if(n==2)list.add("Twenty");
        if(n==3)list.add("Thirty");
        if(n==4)list.add("Forty");
        if(n==5)list.add("Fifty");
        if(n==6)list.add("Sixty");
        if(n==7)list.add("Seventy");
        if(n==8)list.add("Eighty");
        if(n==9)list.add("Ninety");
    }
    private void convertToTens(int n){
        if(n==10)list.add("Ten");
        if(n==11)list.add("Eleven");
        if(n==12)list.add("Twelve");
        if(n==13)list.add("Thirteen");
        if(n==14)list.add("Fourteen");
        if(n==15)list.add("Fifteen");
        if(n==16)list.add("Sixteen");
        if(n==17)list.add("Seventeen");
        if(n==18)list.add("Eighteen");
        if(n==19)list.add("Nineteen");
    }
}
