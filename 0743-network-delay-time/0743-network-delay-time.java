class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int s = times[i][0]-1;
            int d = times[i][1]-1;
            int wt = times[i][2];
            adj.get(s).add(new int[]{d,wt});
        }
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        dist[k-1] = 0;
        pq.add(new int[]{0,k-1});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];
            if(d>dist[node]) continue;
            
            for(int i=0;i<adj.get(node).size();i++){
                int neigh = adj.get(node).get(i)[0];
                int weight = adj.get(node).get(i)[1];

                if(d+weight < dist[neigh]){
                    dist[neigh] = d+weight;
                    pq.add(new int[]{dist[neigh],neigh});
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(dist[i]>res) res = dist[i];
        }
        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }
}