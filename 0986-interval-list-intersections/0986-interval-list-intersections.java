class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        int n = firstList.length;
        int m = secondList.length;
        List<int[]> res = new ArrayList<>();

        while(i<n && j<m){
            int start = Math.max(firstList[i][0],secondList[j][0]);
            int end = Math.min(firstList[i][1],secondList[j][1]);

            if(start<=end){
                res.add(new int[]{start,end});
            }
            if(firstList[i][1]<secondList[j][1]) i++;
            else if(firstList[i][1]>secondList[j][1]) j++;
            else{
                i++;
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}