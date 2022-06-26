class Solution {
    public int maxScore_tl(int[] cardPoints, int k) {
        return helper(cardPoints, k, 0,cardPoints.length - 1);
    }
    
    private int helper(int[] cardPoints, int k, int left, int right) {
        if (k == 0) {
            return 0;
        }
        if (left > right) return -987654321; 
        
        int leftSum = cardPoints[left] + helper(cardPoints, k - 1, left + 1, right);
        int rightSum = cardPoints[right] + helper(cardPoints, k - 1, left, right - 1);
        return Math.max(leftSum, rightSum);
    }
    
    
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length - k;
        int total = 0;
        for (int i = 0; i < cardPoints.length; ++i) {
            total += cardPoints[i];
        }
        if (len == 0) {
            return total;
        }
        
        int start = 0;
        int minSum = Integer.MAX_VALUE;
        int localSum = 0;
        for (int i = 0; i < cardPoints.length; ++i) {
            if (i - start + 1 > len) {
                localSum -= cardPoints[start++];
            }
            localSum += cardPoints[i];
            if (i - start + 1 == len) {
                minSum = Math.min(minSum, localSum);
            }   
        }
        return total - minSum;
    }
}
