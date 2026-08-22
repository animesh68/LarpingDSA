class Solution {
    public int maxSubArray(int[] nums) {
        int bst = nums[0];
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            int v1 = bst + nums[i];
            int v2 = nums[i];
            bst = Math.max(v1,v2);
            ans = Math.max(ans,bst);
        }
        return ans;
    }
}