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
        
        return list.toArray(new int[list.size()][2]);
    }
}
