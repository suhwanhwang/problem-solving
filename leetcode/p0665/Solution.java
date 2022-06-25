class Solution {
    public boolean checkPossibility(int[] nums) {
        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]){
                index = i;
                break;
            }
        }
        //System.out.println(index);
        boolean isOk = true;
        
        // remove i - 1
        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            int cur = nums[i];
            if (i == index) {
                prev = (i >= 2 ? nums[i - 2] : Integer.MIN_VALUE);
            }
            
            if (prev > cur){
                //System.out.println("i-1 " + prev + " > " + cur);
                isOk = false;
                break;
            }
        }
        if (isOk) return true;
        
        // remove i
        isOk = true;
        for (int i = 1; i < nums.length; i++) {
            if (i == index) continue;
            
            int prev = nums[i - 1];
            int cur = nums[i];
            if (i == index + 1) {
                prev = (i >= 2 ? nums[i - 2] : Integer.MIN_VALUE);
            }
            
            if (prev > cur){
                //System.out.println("i " + prev + " > " + cur);
                isOk = false;
                break;
            }
        }
        return isOk;
    }
}
