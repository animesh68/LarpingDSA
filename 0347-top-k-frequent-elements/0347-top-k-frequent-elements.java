class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int num = nums[i];
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

         ArrayList<Map.Entry<Integer, Integer>> entries =
            new ArrayList<>(freq.entrySet());

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[1]-b[1]);

        for (int i = 0; i < entries.size(); i++) {

            int num = entries.get(i).getKey();
            int count = entries.get(i).getValue();

            minHeap.add(new int[]{num, count});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll()[0];
        }

        return ans;

    }
}