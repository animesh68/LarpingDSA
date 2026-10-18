class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxsum = nums[0];
        int minsum = nums[0];
        int sum = nums[0];

        for(int i=1;i<nums.length;i++){
            max = Math.max(nums[i],max+nums[i]);
            min = Math.min(nums[i],min+nums[i]);
            maxsum = Math.max(max,maxsum);
            minsum = Math.min(min,minsum);

            sum += nums[i];
        }
        if(maxsum<0) return maxsum;
        return Math.max(maxsum,sum-minsum);
    }
}