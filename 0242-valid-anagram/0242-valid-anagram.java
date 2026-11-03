class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        HashMap<Character,Integer> have = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();

        for(int i=0;i<n;i++){
            have.put(s.charAt(i),have.getOrDefault(s.charAt(i),0)+1);
        }
         for(int i=0;i<m;i++){
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }
        return have.equals(need);
    }
}