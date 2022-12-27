class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] deltas = new int[rocks.length];
        for (int i = 0; i < rocks.length; ++i) {
            deltas[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(deltas);
        int sum = 0;
        for (int i = 0; i < deltas.length; ++i) {
            sum += deltas[i];
            if (sum > additionalRocks) {
                return i;
            }
        }
        return deltas.length;
    }
}
