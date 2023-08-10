class Solution {
    /*
     0 1 2 3 4 5 6 
    [2,5,6,0,0,1,2] 3
    
    */
    public boolean search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }
    
    private boolean helper(int[] nums, int target, int left, int right) {
        if (/*nums[left] == nums[right] ||*/ left == right) {
            return nums[left] == target;
        }
        
        if (nums[left] < nums[right]) {
            return binSearch(nums, target, left, right);
        }
        
        int mid = (left + right) >>> 1;
        if (helper(nums, target, left, mid)) {
            return true;
        }
        
        if (helper(nums, target, mid + 1, right)) {
            return true;
        }
        
        return false;
    }
    
    private boolean binSearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
        
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
