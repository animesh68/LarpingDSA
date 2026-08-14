class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> f = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            f.put(ch,f.getOrDefault(ch,0)+1);
        }

        boolean odd = false;
        int res = 0;

        for(char ch : f.keySet()){
            int val = f.get(ch);
            res += (val/2)*2;

            if(val%2==1){
                odd = true;
            }
        }
        if(odd){
            return res+1;
        }
        return res;
    }
}