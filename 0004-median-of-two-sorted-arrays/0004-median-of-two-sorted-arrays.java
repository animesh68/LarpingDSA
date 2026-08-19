class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] res = new int[n+m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                res[k] =  nums1[i];
                i++;
            } else {
                res[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < n) {
            res[k] = nums1[i];
            i++;
            k++;
        }
        while (j < m) {
            res[k] = nums2[j];
            j++;
            k++;
        }
        if((m+n)%2!=0){
            return res[(n+m)/2];
        }
        int x = res[((n+m)/2) - 1];
        int y = res[(n+m)/2];
        double z = x+y;
        return z/2 ;
    }
}