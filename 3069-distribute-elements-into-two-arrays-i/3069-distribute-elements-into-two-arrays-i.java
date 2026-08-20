class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> nums1 = new ArrayList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();

        nums1.add(nums[0]);
        nums2.add(nums[1]);
        for(int i=2;i<nums.length;i++){
            if(nums1.get(nums1.size()-1) > nums2.get(nums2.size()-1)){
                nums1.add(nums[i]);
            }
            else{
                nums2.add(nums[i]);
            }
        }
        ArrayList<Integer> merged = new ArrayList<>();
        merged.addAll(nums1);
        merged.addAll(nums2);

        int[] res = new int[merged.size()];
        for(int i=0;i<nums.length;i++){
            res[i] = merged.get(i);
        }

        return res;
    }
}