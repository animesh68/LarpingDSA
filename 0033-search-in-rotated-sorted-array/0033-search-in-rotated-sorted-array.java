class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int n = nums.length;
        int right = n-1;
        int res = 0;

        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }

            else if(nums[mid]>nums[n-1]){
                if(nums[mid]>target && target>=nums[left]){
                    right = mid-1;
                }
                else left = mid+1;
            }
            else{
                if(nums[mid]<target && target<=nums[right]){
                    left = mid+1;
                }
                else right = mid-1;
            }
        }
        return -1;
    }
}