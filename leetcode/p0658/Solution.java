/*
https://leetcode.com/problems/find-k-closest-elements/

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 10^4
arr is sorted in ascending order.
-10^4 <= arr[i], x <= 10^4

*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < arr.length; ++i) {
            tmp.add(i);
        }
        
        Collections.sort(tmp, (t1, t2) -> {
            int d1 = Math.abs(arr[t1] - x);
            int d2 = Math.abs(arr[t2] - x);
            if (d1 == d2) {
                return arr[t1] - arr[t2];
            }
            return d1 - d2;
        });
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            ans.add(arr[tmp.get(i)]);
        }
        Collections.sort(ans);
        return ans;
    }
}
