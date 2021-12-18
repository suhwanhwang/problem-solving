class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        
        for (int i = len - 1; i >= 0; --i) {
            int num = s.charAt(i) - '0';
            for (String d : digits) {
                if (Integer.valueOf(d) < num) {
                    dp[i] += Math.pow(digits.length, len - i - 1);
                } else if (Integer.valueOf(d) == num) {
                    dp[i] += dp[i + 1];
                }
            }
        }
        
        for (int i = 1; i < len; ++i) {
            dp[0] += Math.pow(digits.length, i);
        }
        return dp[0];
    }
}

class Solution1 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        if (digits.length == 9) {
            return n;
        }
        
        int[] nums = new int[digits.length];
        for (int i = 0; i < digits.length; ++i) {
            nums[i] = Integer.parseInt(digits[i]);
        }
        
        int count = 0;
        for (int i = 1; i <= n; ++i) {
            if (isOk(nums, i)) {
                count ++;
            }
        }
        return count;
    }
    
    private boolean isOk(int[] digits, int n) {
        while(n > 0) {
            int num = n % 10;
            boolean isFound = false;
            for (int i = 0; i < digits.length; ++i) {
                if (digits[i] == num) {
                    isFound = true;
                }
            }
            if (!isFound) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
