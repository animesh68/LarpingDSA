class Solution {
    boolean valid(int i, int j, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m) return false;
        return true;
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);

        int[] x = {1,-1,0,0};
        int[] y = {0,0,1,-1};

        dist[0][0] = 0;
        pq.add(new int[]{0,0,0});

        while (!pq.isEmpty()) {

            int[] p = pq.poll();

            int effort = p[0];
            int row = p[1];
            int col = p[2];

            if (effort > dist[row][col])
                continue;

            for (int k = 0; k < 4; k++) {

                int nr = row + x[k];
                int nc = col + y[k];

                if (!valid(nr, nc, n, m))
                    continue;

                int absdiff = Math.abs(
                    heights[row][col] - heights[nr][nc]
                );

                int newEffort = Math.max(effort, absdiff);

                if (newEffort < dist[nr][nc]) {

                    dist[nr][nc] = newEffort;

                    pq.add(new int[]{
                        newEffort,
                        nr,
                        nc
                    });
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}