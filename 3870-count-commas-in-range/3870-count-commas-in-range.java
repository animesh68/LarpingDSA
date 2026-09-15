class Solution {
    public int countCommas(int n) {
        int count = 0;
        int m = n;
        while(m>0){
            m = m/10;
            count++;
        }
        if(count <= 3) return 0;
        else return n-999;
    }
}