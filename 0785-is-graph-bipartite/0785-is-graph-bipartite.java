class Solution {
    boolean res = true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<Integer> col = new ArrayList<>();
        for(int i=0;i<n;i++){
            col.add(-1);
        }
        for(int i=0;i<n;i++){
            if(col.get(i)==-1){
                dfs(graph,i,0,col);
            }
        }
        return res;
    }
    void dfs(int[][] graph, int node, int c, List<Integer> col){
        col.set(node,c);

        for(int j=0;j<graph[node].length;j++){
            int neigh = graph[node][j];
            if(col.get(neigh)!= -1 && col.get(neigh) == col.get(node)) res = false;
            if(col.get(neigh)== -1) dfs(graph,neigh,1-c,col);
        }
        return;
    }
}