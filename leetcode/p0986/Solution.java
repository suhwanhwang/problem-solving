class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        for (int[] f : firstList) {
            for (int[] s : secondList) {
                int[] left = f;
                int[] right = s;
                if(f[0] > s[0]) {
                    left = s;
                    right = f;
                }
                
                if (right[0] >= left[0] && right[0] <= left[1]) {
                    ans.add(new int[]{right[0], Math.min(left[1],right[1])});
                }
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
