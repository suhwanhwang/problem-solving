class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : -(a[0] - b[0])));
        /*
        for (int[] p : people) {
            System.out.println(p[0] + " " + p[1]);
        }
        */
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        
        int[][] ans = new int[people.length][2];
        for (int i = 0; i < list.size(); ++i) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        
        return ans;
    }
}
