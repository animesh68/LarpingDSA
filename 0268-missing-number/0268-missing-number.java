class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalsum = 0;
        int sum = 0;
        for(int i=0;i<=n;i++) totalsum += i;
        for(int i=0;i<n;i++) sum += nums[i];
        return totalsum - sum;
    }
}