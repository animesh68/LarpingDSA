class Solution {
    public int[] dailyTemperatures(int[] a) {
        Stack<Integer> st = new Stack<>();
        int n = a.length;
        int[] res = new int[n];
        res[n-1] = 0;

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && a[i] >= a[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = 0;
            }
            else{
                res[i] = st.peek()-i;
            }
            st.push(i);
        }
        return res;
    }
}