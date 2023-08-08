class Solution {
    /*
    1,2,3,4,5,6,7,0
    2,3,4,5,6,7,0,1
    3,4,5,6,7,0,1,2
    4,5,6,7,0,1,2,3
    */
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    private int helper(int[] nums, int target, int left, int right) {
        if (left > right || right >= nums.length) {
            return -1;
        }
        if (left == right) {
            return nums[left] == target ? left : -1;
        }

        if (nums[left] <= target && target <= nums[right]) {
            return binSearch(nums, target, left, right);
        }

        int mid = (left + right) >>> 1;
        int leftResult = helper(nums, target, left, mid);
        if (leftResult != -1) {
            return leftResult;
        }

        int rightResult = helper(nums, target, mid + 1, right);
        if (rightResult != -1) {
            return rightResult;
        }
        
        return -1;
    }

    private int binSearch(int[] nums, int target, int left, int right) {
        
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
