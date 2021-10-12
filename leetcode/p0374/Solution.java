/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int m = (low + high)>>>1;
            switch(guess(m)) {
                case -1:
                    high = m - 1;
                    break;
                case 0:
                    return m;
                case 1:
                    low = m + 1;
                    break;
            }
        }
        return 0;
    }
}
