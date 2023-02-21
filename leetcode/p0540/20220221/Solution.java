class Solution {
    /*
0 1 2 3 4 5 6 7 8 
1,1,2,3,3,4,4,8,8
        ^
          ^

    */
    public int singleNonDuplicate(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int other = mid ^ 0x1;

            if (other < nums.length && nums[mid] == nums[other]) {
                left = mid + 1;
            } else {
                int other2 = (mid == 0 ? -1 : nums[other > mid ? mid - 1 : mid + 1]);
                if (nums[mid] != other2) {
                    return nums[mid];
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
