class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int median = 0;

        if(n%2==0){
            median = (nums[n/2 - 1] + nums[n/2])/2;
        }
        else{
            median = nums[n/2];
        }
        int res = 0;
        for(int i=0;i<n;i++){
            res += Math.abs(median - nums[i]);
        }
        return res;
    }
}