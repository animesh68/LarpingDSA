class Solution {
   public int maximumUnits(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

    int units = 0;

    for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
        int take = Math.min(boxTypes[i][0], truckSize);
        units += take * boxTypes[i][1];
        truckSize -= take;
    }

    return units;
}
}