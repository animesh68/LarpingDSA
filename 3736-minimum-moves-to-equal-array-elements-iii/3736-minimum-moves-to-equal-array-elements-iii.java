class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        int target = nums[n-1];
        for(int i=0;i<n;i++){
            res += target-nums[i];
        }
        return res;
    }
}