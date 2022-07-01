class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> -(a[1] - b[1]));
        int remainBox = truckSize;
        int unit = 0;
        for (int i = 0; i < boxTypes.length && remainBox > 0; ++i) {
            int numBox = Math.min(remainBox, boxTypes[i][0]);
            unit += numBox * boxTypes[i][1];
            remainBox -= numBox;
        }
        return unit;
    }
}
