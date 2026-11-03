class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int guess = (low+high)/2;
            if(nums[guess]==target) return true;
            if(nums[low]==nums[guess] && nums[guess]==nums[high]){
                low++;
                high--;
            }
            else if(nums[low]<=nums[guess]){
                if(nums[guess]>target && target>=nums[low]) high = guess-1;
                else low = guess+1;
            }
            else{
                if(nums[guess]<target && target<=nums[high]) low = guess+1;
                else high = guess-1;
            }
        }
        return false;
    }
}