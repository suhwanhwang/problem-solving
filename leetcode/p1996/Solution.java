/*
 
 [[4,10],[2,2],[8,8],[10,2],[5,5],[9,10],[2,6]]
 
        max  count 
 10 2   2    0
  9 10  10   0
  8 8        1   
  5 5        2
  4 10  10   2
  2 2        3
  2 6        4
  
 
*/
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return -(a[0] - b[0]);
        });
        
        int weakCount = 0;
        int maxDefense = Integer.MIN_VALUE;
        
        for (int[] p : properties) {
            if (p[1] < maxDefense) {
                weakCount++;
            } else {
                maxDefense = p[1];
            }
        }
        
        return weakCount;
    }
}
