class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        /*
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; ++i) {
            if (arr[i - 1] != arr[i] && (i == arr.length - 1 || arr[i] != arr[i + 1])) {
                return true;
            }

        }
        return false;
        */
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int value : map.values()) {
            if (set.contains(value)) {
                return false;
            }
            set.add(value);
        }
        return true;
    }
}
