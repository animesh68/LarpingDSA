class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int high = 0;
        int maxlen = 0;
        Map<Character,Integer> hm = new HashMap<>();
        while(high<s.length()){
            char ch = s.charAt(high);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.get(ch)>1){
                char leftch = s.charAt(low);
                hm.put(leftch,hm.getOrDefault(leftch,0)-1);

                if(hm.get(leftch)==0){
                    hm.remove(leftch);
                }
                low++;
            }
            int size = high - low + 1;
            maxlen = Math.max(size,maxlen);
            high++;
        }
        return maxlen;
    }
}