/*
https://leetcode.com/problems/count-primes/

Count the number of prime numbers less than a non-negative number, n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106

*/
class Solution {
    
    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int countPrimes_n2(int n) {
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }
    
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        
        for (int i = 2; i * i < n; ++i) {
            if (isPrime[i]) {
                for (int p = i * i; p < n; p += i) {
                    isPrime[p] = false;
                }
            }
        }
        
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
