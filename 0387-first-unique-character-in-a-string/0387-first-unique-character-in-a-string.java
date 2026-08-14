class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        HashMap<Character,Integer> f = new HashMap<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            f.put(ch,f.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int val = f.get(ch);
            if(val==1){
                return i;
            }
        }
        return -1;
    }
}