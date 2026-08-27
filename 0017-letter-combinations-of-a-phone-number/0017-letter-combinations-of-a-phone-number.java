class Solution {
    String[] map = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;
        heykitRUthere(digits,0,new StringBuilder(),res);
        return res;
    }
    void heykitRUthere(String digits, int i, StringBuilder s, List<String> res){
        if(i == digits.length()){
            res.add(s.toString());
            return;
        }

        String letters = map[digits.charAt(i)-'0'];

        for(int j=0;j<letters.length();j++){
            s.append(letters.charAt(j));
            heykitRUthere(digits,i+1,s,res);
            s.deleteCharAt(s.length()-1);
        }
    }
}