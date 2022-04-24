class UndergroundSystem {

    static class StartEnd {
        String start;
        String end;
        public StartEnd(String start, String end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
        
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof StartEnd)) {
                return false;
            }
            StartEnd other = (StartEnd)o;
            return start.equals(other.start) && end.equals(other.end);
        }
    }

    Map<Integer, Integer> startTimeMap = new HashMap<>();
    Map<Integer, String> startStationMap = new HashMap<>();
    Map<StartEnd, Integer> totalMap = new HashMap<>();
    Map<StartEnd, Integer> countMap = new HashMap<>();
    
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        startTimeMap.put(id, t);
        startStationMap.put(id, stationName);
    }
    
    public void checkOut(int id, String stationName, int t) {
        int startTime = startTimeMap.get(id);
        String startStation = startStationMap.get(id);
        StartEnd key = new StartEnd(startStation, stationName);
        totalMap.put(key, totalMap.getOrDefault(key,0)+t - startTime);
        countMap.put(key, countMap.getOrDefault(key,0)+1);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        StartEnd key = new StartEnd(startStation, endStation);
        return (double)totalMap.get(key) / countMap.get(key);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
