class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,new StringBuilder(),0,0,n);
        return res;
    }
    static void backtrack(List<String> res, StringBuilder s, int open, int closed, int n){
        if(open==n && closed==n){
            res.add(s.toString());
            return;
        }

        if(open<n){
            s.append('(');
            backtrack(res,s,open+1,closed,n);
            s.deleteCharAt(s.length()-1);
        }

        if(closed<open){
            s.append(')');
            backtrack(res,s,open,closed+1,n);
            s.deleteCharAt(s.length()-1);
        }
    }
}