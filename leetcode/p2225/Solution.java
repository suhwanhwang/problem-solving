class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> loseMap = new HashMap<>();
        Set<Integer> playerSet = new TreeSet<>();

        for (int[] match : matches) {
            playerSet.add(match[0]);
            playerSet.add(match[1]);
            loseMap.put(match[1], loseMap.getOrDefault(match[1], 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        for (int p : playerSet) {
            int count = loseMap.getOrDefault(p, 0);
            if (count <= 1) {
                ans.get(count).add(p);
            }
        }
        return ans;
    }
}
