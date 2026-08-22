class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> entries =
            new ArrayList<>(freq.entrySet());

        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < k; i++) {
            int num = entries.get(i).getKey();
            int count = entries.get(i).getValue();

            minHeap.add(new int[]{num, count});
        }

        for (int i = k; i < entries.size(); i++) {

            int num = entries.get(i).getKey();
            int count = entries.get(i).getValue();

            if (count > minHeap.peek()[1]) {
                minHeap.poll();
                minHeap.add(new int[]{num, count});
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll()[0];
        }

        return res;
    }
}