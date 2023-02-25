class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) 
            return new int[]{-1,-1};
        int lower = lowerBound(nums, target);
        int upper = upperBound(nums, target);
        if (lower == nums.length || nums[lower] != target) {
            lower = -1;
        }
        if ((upper == nums.length && nums[upper - 1] != target) || upper == 0) {
            upper = -1;
        }
        if (upper != -1 && nums[upper - 1] == target) {
            upper--;
        } else {
            upper = -1;
        }
        return new int[]{lower,upper};
    }
    
    private int lowerBound(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;
    
        while(begin < end) {
    	    int mid = (begin + end) >>> 1;
        
            if(nums[mid] >= target) {
        	    end = mid;
            } else {
        	    begin = mid + 1;
            }
        }
        return end;
    }
    
    private int upperBound(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;
    
        while(begin < end) {
    	    int mid = (begin + end) >>> 1;
        
            if(nums[mid] <= target) {
                begin = mid + 1;
            } else {
        	    end = mid;
            }
        }
        return end;
    }
}
