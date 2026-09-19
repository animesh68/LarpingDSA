class Solution {
    public int climbStairs(int n) {
        return climb(n,0);
    }
    Map<Integer,Integer> dp = new HashMap<>();
    public int climb(int n,int i){
        if(i==n) return 1;
        if(i>n) return 0;
        if(dp.containsKey(i)){
            return dp.get(i);
        }
        int ans = climb(n,i+1) + climb(n,i+2);
        dp.put(i,ans);
        return ans;
    }
}