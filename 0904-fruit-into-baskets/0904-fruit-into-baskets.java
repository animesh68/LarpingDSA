class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        int n = fruits.length;
        while(right<n){
            int ch = fruits[right];
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>2){
                int low = fruits[left];
                map.put(low,map.get(low)-1);
                if(map.get(low)==0){
                    map.remove(low);
                }
                left++;
            }
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}