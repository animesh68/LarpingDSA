class Solution {
    public boolean checkDivisibility(int n) {
        int digit = 0;
        int sum = 0;
        int product = 1;
        int m = n;
        while(n!=0){
            digit = n%10;
            n = n/10;
            sum += digit;
            product *= digit;
        }
        if(m%(sum+product)==0) return true;
        else return false;
    }
}