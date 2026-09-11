class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int low = grid[0][0];
        int high = grid[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>high) high = grid[i][j];
            }
        }
        int res = 0;
        while(low<=high){
            int guess = (low+high)/2;
            if(bfs(grid,guess,n,m)){
                res = guess;
                high = guess - 1;
            }
            else{
                low = guess + 1;
            }
        }
        return res;
    }
    boolean bfs(int[][] grid, int guess, int n, int m){
        int[] x = {1,-1,0,0};
        int[] y = {0,0,1,-1};
        Queue<int[]> pq = new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int k=0;k<n;k++){
            Arrays.fill(vis[k], Integer.MAX_VALUE);
        }
        vis[0][0] = 0;
        pq.add(new int[]{0,0,0});
        if(grid[0][0] > guess)
            return false;
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int row = p[0];
            int col = p[1];
            if(row == n - 1 && col == m - 1)
                return true;
            for(int k = 0; k < 4; k++){

                int nr = row + x[k];
                int nc = col + y[k];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m ||
                vis[nr][nc] != Integer.MAX_VALUE ||
                grid[nr][nc] > guess)
                    continue;

                vis[nr][nc] = 0;
                pq.add(new int[]{nr, nc});
            }
        }
        return false;
    }
}