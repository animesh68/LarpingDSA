class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int low = 0;
        int high = 0;
        int maxlen = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(high<n){
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);
            int size = high-low+1;
            while(map.size()<size){
                char cl = s.charAt(low);
                map.put(cl,map.getOrDefault(cl,0)-1);
                if(map.get(cl)==0) map.remove(cl);
                low++;
                size = high-low+1;
            }
            maxlen = Math.max(maxlen,size);
            high++;
        }
        return maxlen;
    }
}