class MedianFinder {
    // maxQ      minQ 
    // 1 2 3     4 5
    //     ^
    private final PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> {
        return -(a - b);
    });
    private final PriorityQueue<Integer> minQ = new PriorityQueue<>();
    

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        maxQ.offer(num);

        if (!minQ.isEmpty() && maxQ.peek() > minQ.peek()) {
            minQ.offer(maxQ.poll());
        }

        if (maxQ.size() - minQ.size() > 1) {
            minQ.offer(maxQ.poll());
        } else if (minQ.size() - maxQ.size() > 1) {
            maxQ.offer(minQ.poll());
        }
    }
    
    public double findMedian() {
        if (minQ.size() == maxQ.size()) {
            return (minQ.peek() + maxQ.peek()) / 2.0;
        } else {
        
            return (maxQ.size() > minQ.size() ? maxQ.peek() : minQ.peek());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
