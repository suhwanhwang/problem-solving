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
