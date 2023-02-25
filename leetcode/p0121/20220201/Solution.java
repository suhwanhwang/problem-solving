class Solution {
    /*
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    
    7 1 5 3 6 4
max 0 0 4 4 5 5
min 7 1 1 1 1 1 
    */
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = prices[0];
        for(int p : prices) {
            max = Math.max(max, p - minPrice);
            minPrice = Math.min(minPrice, p);
        }
        return max;
    }
}
