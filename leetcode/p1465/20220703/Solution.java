class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        return (int)((getMaxGap(h, horizontalCuts) * getMaxGap(w, verticalCuts)) % (int)(1e9 + 7));
    }
    
    private long getMaxGap(int length, int[] cuts) {
        Arrays.sort(cuts);
        long maxGap = cuts[0];
        for (int i = 1; i < cuts.length; ++i) {
            maxGap = Math.max(maxGap, cuts[i] - cuts[i - 1]);
        }
        maxGap = Math.max(maxGap, length - cuts[cuts.length - 1]);
        return maxGap;
    }
}
