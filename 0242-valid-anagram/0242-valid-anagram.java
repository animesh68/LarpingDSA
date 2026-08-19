class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n!=m) return false;
        
        int[] x = new int[26];
        int[] y = new int[26];

        for(int i=0;i<s.length();i++){
            x[s.charAt(i)-'a']++;
            y[t.charAt(i)-'a']++;
        }
        if(Arrays.equals(x,y)) return true;
        return false;
    }
}