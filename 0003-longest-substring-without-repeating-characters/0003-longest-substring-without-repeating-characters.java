class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int high = 0;
        int maxlen = 0;
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        while(high<n){
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.get(ch)>1){
                char left = s.charAt(low);
                map.put(left,map.get(left)-1);

                if(map.get(left)==0) map.remove(left);
                low++;
            }
            maxlen = Math.max(maxlen,high-low+1);
            high++;
        }
        return maxlen;
    }
}