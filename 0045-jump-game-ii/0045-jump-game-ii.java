class Solution {
    public int jump(int[] nums) {
        int jumps = 0, reach = 0, end = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            reach = Math.max(reach, i + nums[i]);

            if(i == end) {
                jumps++;
                end = reach;
            }
        }

        return jumps;
    }
}