class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxlen = 0;
        int ans = 0;
        int[] freq = new int[26];
        int n = s.length();

        for(int right=0;right<n;right++){
            freq[s.charAt(right)-'A']++;

            maxlen = Math.max(maxlen,freq[s.charAt(right)-'A']);
            int size = right - left + 1;
            while(size-maxlen>k){
                freq[s.charAt(left)-'A']--;
                left++;
                size = right-left+1;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}