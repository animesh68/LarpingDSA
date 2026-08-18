class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        int res = -1;
        int n = piles.length;
        for(int i=0;i<n;i++){
            if(piles[i]>high){
                high = piles[i];
            }
        }
        while(low<=high){
            int guess = (low+high)/2;
            long hours = gethours(piles,guess);
            if(hours>h) low = guess + 1;
            else{
                res = guess;
                high = guess - 1;
            }
        }
        return res;
    }
    static long gethours(int[] piles, int guess){
        long h = 0;
        for(int i=0;i<piles.length;i++){
            h += piles[i]/guess;
            if(piles[i]%guess != 0) h++;
        }
        return h;
    }
}