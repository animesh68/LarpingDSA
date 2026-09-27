class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for(int i=0;i<n;i++){
            res[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    res[i] = Math.max(res[i],res[j]+1);
                }
            }
        }
        int ans = -1;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,res[i]);
        }
        return ans;
    }
    // public int ana(int[] nums, int n, int i, int prev, int[][] dp){
    //     if(i==n) return 0;
    //     if(dp[i][prev+1] != -1) return dp[i][prev+1];
    //     if(prev == -1 || nums[i] > nums[prev]){
    //         int c1 = 1 + ana(nums,n,i+1,i,dp);
    //         int c2 = ana(nums,n,i+1,prev,dp);
    //         return dp[i][prev+1] = Math.max(c1,c2);
    //     }
    //     return dp[i][prev+1] = ana(nums,n,i+1,prev,dp);
    // }
}