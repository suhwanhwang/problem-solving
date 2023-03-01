class Solution {
    public int[] sortArray(int[] nums) {
        //Arrays.sort(nums);
        //qsort(nums,0,nums.length-1);
        mergeSort(nums,0, nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) >>> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1,right);
        
        int[] merged = new int[right-left+1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while(i <= mid || j <= right) {
            int n1 = (i<=mid?nums[i]:Integer.MAX_VALUE);
            int n2 = (j<=right?nums[j]:Integer.MAX_VALUE);
            if (n1 < n2) {
                merged[index] = n1;
                i++;
            } else {
                merged[index] = n2;
                j++;
            }
            index++;
        }

        for (int k = 0; k < merged.length; ++k) {
            nums[left+k] = merged[k];
        }
    }
/*
   0 1 2 3
   1 2 3 5
l  ^
r        ^
i        ^
j        ^
*/
    private void qsort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int val = nums[left];
        int i = left;
        int j = i;
        while(i <= right) {
            if (nums[i] < val) {
                j++;
                swap(nums, i, j);
            }
            i++;
        }
        swap(nums, left, j);
        qsort(nums,left, j-1);
        qsort(nums,j+1, right);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
