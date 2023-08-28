class MyStack {
    private final List<Queue<Integer>> queues = Arrays.asList(new ArrayDeque<>(), new ArrayDeque<>());
    private int cur = 0;

    public MyStack() {
        
    }
    
    public void push(int x) {
        queues.get(cur).offer(x);
    }
    
    public int pop() {
        int other = (cur ^ 1);
        while (queues.get(cur).size() > 1) {
            int num = queues.get(cur).poll();
            queues.get(other).offer(num);
        }
        int last = queues.get(cur).poll();
        cur = other;
        return last;
    }
    
    public int top() {
        int other = (cur ^ 1);
        while (queues.get(cur).size() > 1) {
            int num = queues.get(cur).poll();
            queues.get(other).offer(num);
        }
        int last = queues.get(cur).peek();
        return last;
    }
    
    public boolean empty() {
        return queues.get(cur).isEmpty();
    }
}
