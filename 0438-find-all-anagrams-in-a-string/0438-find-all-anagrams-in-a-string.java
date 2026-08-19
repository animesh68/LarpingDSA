class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        if(m>n) return new ArrayList<>();
        int low = 0;
        int high = m-1;
        List<Integer> res = new ArrayList<>();

        int[] fq = new int[26];
        int[] window = new int[26];

        for(int i=0;i<m;i++){
            fq[p.charAt(i)-'a']++;
            window[s.charAt(i)-'a']++;
        }

        while(high<n){
            if(Arrays.equals(fq,window)){
                res.add(low);
            }
            window[s.charAt(low)-'a']--;
            low++;
            high++;
            if (high < n) {
                window[s.charAt(high) - 'a']++;
            }
        }
        return res;
    }
}