class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[] res = dist(points);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        for(int i=0;i<k;i++){
            pq.add(new int[]{res[i],i});
        }

        for(int i=k;i<n;i++){
            if(res[i] < pq.peek()[0]){
                pq.poll();
                pq.add(new int[]{res[i],i});
            }
        }
        int[][] ans = new int[k][2];

        for(int i=0;i<k;i++){
            int index = pq.poll()[1];
            ans[i] = points[index];
        } 
        return ans;
    }
    static int[] dist(int[][] points){
        int n = points.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            int x = points[i][0];
            int y = points[i][1];

            arr[i] = (x*x)+(y*y);
        }
        return arr;
    }
}