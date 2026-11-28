class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        int n = prerequisites.length;
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            adj.get(src).add(dest);
            indegree[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.offer(i);
        }

        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int j=0;j<adj.get(node).size();j++){
                int neigh = adj.get(node).get(j);
                indegree[neigh]--;

                if(indegree[neigh]==0) q.offer(neigh);
            }
        }
        return count==numCourses;
    }
}