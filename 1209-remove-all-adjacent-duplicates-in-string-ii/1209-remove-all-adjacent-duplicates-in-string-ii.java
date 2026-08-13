class Solution {
    public String removeDuplicates(String s, int k) {

        Stack<Character> st = new Stack<>();
        Stack<Integer> count = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (st.empty()) {
                st.push(c);
                count.push(1);
                continue;
            }

            if (st.peek() != c) {
                st.push(c);
                count.push(1);
                continue;
            }

            
            if (count.peek() < k - 1) {
                count.push(count.pop() + 1);
                continue;
            }

            st.pop();
            count.pop();
        }

        StringBuilder res = new StringBuilder();

        while (!st.empty()) {

            char c = st.pop();
            int cnt = count.pop();

            while (cnt > 0) {
                res.append(c);
                cnt--;
            }
        }

        return res.reverse().toString();
    }
}