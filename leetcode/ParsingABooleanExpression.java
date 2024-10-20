//https://leetcode.com/problems/parsing-a-boolean-expression/submissions/
class Solution {
    int i;
    public boolean parseBoolExpr(String expression) {
        return solve(expression.toCharArray());
    }
    public boolean solve(char[] exp){
        boolean val=true;
        if(exp[i]=='&'){
            i+=2;
            val=solveAnd(exp);
        }
        else if(exp[i]=='|'){
            i+=2;
            val=solveOr(exp);
        }
        else if(exp[i]=='!'){
            i+=2;
            val=solveNot(exp);
        }
        else{
            val=(exp[i]=='t');
            i++;
        }
        return val;
    }
    public boolean solveAnd(char[] exp){
        boolean val=true;
        while(exp[i]!=')'){
            if(exp[i]==',')i++;
            val= val & solve(exp);
        }
        i++;//closing bracket
        return val;
    }
    public boolean solveOr(char[] exp){
        boolean val=false;
        while(exp[i]!=')'){
            if(exp[i]==',')i++;
            val= val | solve(exp);
        }
        i++;
        return val;
    }
    public boolean solveNot(char[] exp){
        boolean val= !solve(exp);
        i++;
        return val;
    }
}
