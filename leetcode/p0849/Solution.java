class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        for (int i = 0; i < seats.length; ++i) {
            if (seats[i] == 1) {
                continue;
            }
            
            int distance = getDistance(seats, i);
            maxDistance = Math.max(maxDistance, distance);
        }
        return maxDistance;
    }
    
    private int getDistance(int[] seats, int index) {
        int distance = seats.length;
        for (int i = index - 1; i >= 0; --i) {
            if (seats[i] == 1) {
                distance = index - i;
                break;
            }
        }
        
        for (int i = index + 1; i < seats.length; ++i) {
            if (seats[i] == 1) {
                distance = Math.min(distance, i - index);
                break;
            }
        }
        return distance;
    }
}
