class Solution {
    public boolean isPalindrome(String s) {
        Stack<Character> st = new Stack<>();
        s = s.replaceAll("[^a-zA-Z0-9]" , "").toLowerCase();
        int n = s.length();

        for(int i=0;i<n;i++){
            st.push(s.charAt(i));
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        if(s.equals(ans.toString())) return true;
        return false;
    }
}