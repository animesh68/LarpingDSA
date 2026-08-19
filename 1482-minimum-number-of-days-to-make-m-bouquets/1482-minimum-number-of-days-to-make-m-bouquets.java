class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long x = (long) m * k;
        int n = bloomDay.length;

        if (x > n) {
            return -1;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            left = Math.min(left, bloomDay[i]);
            right = Math.max(right, bloomDay[i]);
        }

        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    static boolean canMake(int[] bloomDay, int m, int k, int days) {
        int flowers = 0;
        int bouquets = 0;

        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= days) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;

                    if (bouquets == m) {
                        return true;
                    }
                }
            } 
            else {
                flowers = 0;
            }
        }

        return false;
    }
}