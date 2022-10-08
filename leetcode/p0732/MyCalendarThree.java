class MyCalendarThree {
    private final Map<Integer,Integer> diff = new TreeMap<>();
    public MyCalendarThree() {
        
    }
    
    public int book(int start, int end) {
        diff.put(start, diff.getOrDefault(start, 0) + 1);
        diff.put(end, diff.getOrDefault(end, 0) - 1);
        int cur = 0;
        int max = 0;
        for(int d : diff.values()) {
            cur += d;
            max = Math.max(max, cur);
        }
        return max;
    }
}
