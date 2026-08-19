class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0) count++;
        }
        if(count>=2) return new int[n];

        if(count==1){
            int prozero = 1;
            int index = 0;
            for(int i=0;i<n;i++){
                if(nums[i]==0){
                    index = i;
                    continue;
                }
                prozero *= nums[i];
            }
            for(int i=0;i<n;i++){
                if(i==index) nums[i] = prozero;
                else{
                    nums[i]=0;
                }
            }
        }
        else{
            int product = 1;
            for(int i=0;i<n;i++){
                product *= nums[i];
            }
            for(int i=0;i<n;i++){
                nums[i] = product/nums[i];
            }
        }
        return nums;
    }
}