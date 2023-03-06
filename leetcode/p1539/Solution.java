class Solution {
    public int findKthPositive(int[] arr, int k) {
        int num = 1;
        int remain = k;
        for (int i = 0; i < arr.length; ++i) {
            if (num == arr[i]) {
                num++;
            } else {
                if (arr[i] - num >= remain) {
                    return num + remain - 1;
                } else {
                    remain -= arr[i] - num ;
                    num = arr[i] + 1;
                }
            }
        }

        return num + remain - 1;
    }
}
