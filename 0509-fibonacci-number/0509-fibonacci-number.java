class Solution {
    public int fib(int n) {
        if(n==0 || n==1) return n;
        int prev = 1;
        int prevofprev = 0;
        for(int i = 2;i<=n;i++){
            int ans = prev + prevofprev;
            prevofprev = prev;
            prev = ans;
        }
        return prev;
    }
}