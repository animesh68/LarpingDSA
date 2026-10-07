class Solution {
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int zerocount = 0;
        int maxlen = 0;
        int high = 0;
        while(high<nums.length){
            if(nums[high]==0) zerocount++;
            while(zerocount>k){
                if(nums[low]==0) zerocount--;
                low++;
            }
            maxlen = Math.max(maxlen,high-low+1);
            high++;
        }
        return maxlen;
    }
}