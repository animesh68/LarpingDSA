class Solution {
    public int findMaxLength(int[] nums) {
        int diff = 0;
        int maxlen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) diff--;
            else diff++;

            if(map.containsKey(diff)){
                maxlen = Math.max(maxlen,i-map.get(diff));
            }
            else map.put(diff,i);
        }
        return maxlen;
    }
}