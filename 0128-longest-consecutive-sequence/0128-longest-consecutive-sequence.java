class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n==0) return 0;
        int maxlen = 1;
        int currlen = 1;
        for(int i=1;i<n;i++){
            if(nums[i-1] == nums[i]) continue;
            if(nums[i] - nums[i-1] == 1) currlen++;
            else currlen = 1;
            maxlen = Math.max(currlen,maxlen);
        }
        return maxlen;
    }
}