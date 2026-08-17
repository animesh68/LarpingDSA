class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int res = 0;
        int n = nums.length;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]>nums[n-1]){
                left = mid+1;
            }
            else{
                res = mid;
                right = mid-1;
            }
        }
        return nums[res];
    }
}