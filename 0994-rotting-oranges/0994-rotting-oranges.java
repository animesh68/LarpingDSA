class Solution {
    static boolean valid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m) return false;
        return true;
    }
    public int orangesRotting(int[][] grid) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[] { i, j });
                }
                if(grid[i][j]==1) fresh++;
            }
        }

        while(!q.isEmpty() && fresh>0){
            time++;
            int s = q.size();
            while(s-->0){
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];

                for(int k=0;k<4;k++){
                    int row = r + dx[k];
                    int col = c + dy[k];

                    if(valid(row,col,n,m) && grid[row][col]==1){
                        grid[row][col]=2;
                        fresh--;
                        q.offer(new int[]{row,col});
                    }
                }
            }
        }
        if(fresh>0) return -1;
        return time;
    }
}