class Solution {
    /*

queries = [[1,0],[-3,1],[-4,0],[2,3]]
                                ^

        0   1 2 3
nums = [-2,-1,3,6]

set     0 3
sum     4
    
    */
class Solution {
    /*

queries = [[1,0],[-3,1],[-4,0],[2,3]]
                                ^

        0   1 2 3
nums = [-2,-1,3,6]

set     0 3
sum     4
    
    */
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 0) {
                sum += nums[i];
            }
        }

        int[] ans = new int[queries.length];
        
        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0];
            int index = queries[i][1];
                
            if (nums[index] % 2 == 0) {
                sum -= nums[index];   
            }
            
            nums[index] += val;
            
            if (nums[index] % 2 == 0) {
                sum += nums[index];
            }
            
            ans[i] = sum;
        }
        return ans;
    }
}
}
