class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> have = new HashMap<>();

        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            have.put(ch,have.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<"balloon".length();i++){
            char ch = "balloon".charAt(i);
            need.put(ch,need.getOrDefault(ch,0)+1);
        }

        int res = Integer.MAX_VALUE;
        for(char ch : need.keySet()){
            int needed = need.get(ch);
            int aval = have.getOrDefault(ch,0);

            int count = aval/needed;
            res = Math.min(res,count);
        }
        return res;
    }
}