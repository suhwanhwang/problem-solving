class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = piles[0];
        for (int p : piles) {
            //low = Math.min(low, p);
            high = Math.max(high, p);
        }

        while (low < high) {
            int mid = (low+high)>>>1;
            if (isClear(piles,h,mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isClear(int[] piles, int h, int k) {
        int sum = 0;

        for (int p : piles) {
            sum += (int)Math.ceil((double)p / k);
        }
        return sum <= h;
    }
}
