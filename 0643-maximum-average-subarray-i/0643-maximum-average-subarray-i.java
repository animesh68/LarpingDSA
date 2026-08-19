class Solution {
    public double findMaxAverage(int[] nums, int k) {
      int n = nums.length;
      int left = 0;
      int right = k-1;
      long sum = 0;
      long res = Long.MIN_VALUE;
      for(int i=0;i<k;i++) {
        sum += nums[i];
      }
      res = sum;
      while(right<n-1){
        sum -= nums[left];
        left++;

        right++;
        sum += nums[right];

        res = Math.max(sum,res);
      }
    return (double)res/k;
    }
}