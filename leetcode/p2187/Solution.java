class Solution {
    public long minimumTime_x(int[] time, int totalTrips) {
        // x = totaltrip / (1/t0 + 1/t1 + ...)
        double sum = 0.0;
        for (int t : time) {
            sum += (1.0 / t);
        }

        long ans;
        ans = (long)Math.ceil((double)totalTrips / sum);
        return ans;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long max = time[0];
        for (int t : time) {
            max = Math.max(max, t);
        }
        
        long low = 1;
        long high = max * totalTrips;

        while (low < high) {
            long mid = (low + high) >>> 1;
            System.out.println(low + " " + mid + " " + high);
            if (isComplete(time, totalTrips, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isComplete(int[] time, int totalTrips, long hour) {
        long sum = 0;
        for (int t : time) {
            sum += (hour / t);
        }
        return sum >= totalTrips;
    }
}
