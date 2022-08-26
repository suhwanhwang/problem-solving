class Solution {
    public boolean reorderedPowerOf2(int n) {
        Set<String> sortedPowerOf2Set = new HashSet<>();
        for (int i = 0; i < 31; ++i) {
            int num = (1 << i);
            char[] charArray = String.valueOf(num).toCharArray();
            Arrays.sort(charArray);
            sortedPowerOf2Set.add(new String(charArray));
        }
        char[] charArray = String.valueOf(n).toCharArray();
        Arrays.sort(charArray);
        return sortedPowerOf2Set.contains(new String(charArray));
    }
}
