class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n = nums1.length;
        int m = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<m;i++){
            while(!st.isEmpty() && nums2[i] > st.peek()){
                int j = st.pop();
                map.put(j,nums2[i]);
            }
            st.push(nums2[i]);
        }
        int[] res = new int[n];

        for(int i=0;i<n;i++){
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}