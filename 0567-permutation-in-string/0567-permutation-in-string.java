class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int low = 0;
        int high = m-1;
        int[] fq = new int[26];
        int[] window = new int[26];

        if(m>n) return false;
        for(int i=0;i<m;i++){
            fq[s1.charAt(i)-'a']++;
            window[s2.charAt(i)-'a']++;
        }
        while(high<n){
            if(Arrays.equals(fq,window)) return true;

            window[s2.charAt(low)-'a']--;
            low++;
            high++;
            if(high<n){
                window[s2.charAt(high)-'a']++;
            }
        }
        return false;
    }
}