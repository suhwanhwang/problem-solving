/*
class StockSpanner {
    private List<Integer> stock = new ArrayList<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        stock.add(price);

        int count = 0;
        for (int i = stock.size() - 1; i >= 0; --i) {
            if (price >= stock.get(i)) {
                ++count;
            } else {
                break;
            }
        }
        return count;
    }
}
*/
class StockSpanner {
    private Stack<Integer> stock = new Stack<>();
    private Stack<Integer> count = new Stack<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int sum = 1;
        
        while (!stock.isEmpty() && stock.peek() <= price) {
            stock.pop();
            sum += count.pop();
        }
        
        stock.push(price);
        count.push(sum);
        return sum;
    }
}
