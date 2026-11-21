class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        for(int i=0;i<k;i++){
            int num = entries.get(i).getKey();
            int freq = entries.get(i).getValue();

            pq.add(new int[]{num,freq});
        }

        for(int i=k;i<entries.size();i++){
            int num = entries.get(i).getKey();
            int freq = entries.get(i).getValue();

            if(freq>pq.peek()[1]){
                pq.poll();
                pq.add(new int[]{num,freq});
            }
        }

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}