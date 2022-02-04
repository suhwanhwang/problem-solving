class Solution {
    public int findMaxLength_bf(int[] nums) {
        int zeros = 0;
        int max = 0;
        int[] zcount = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                zeros++;
            }
            zcount[i] = zeros;
        }
        
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; j += 2) {
                int count = zcount[j] - (i > 0 ? zcount[i - 1] : 0);
                if (count == (j - i + 1) / 2) {
                    max = Math.max(max,j - i + 1);
                }
            }
        }
        return max;
    }
    
    public int findMaxLength(int[] nums) {
        int delta = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(-1)));
        for (int i = 0; i < nums.length; ++i) {
            delta += (nums[i] == 0 ? -1 : 1);
            List<Integer> list = map.getOrDefault(delta, new ArrayList<>());
            list.add(i);
            map.put(delta, list);
        }
        //System.out.println(map);
        int max = 0;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() >= 2) {
                max = Math.max(max, list.get(list.size() - 1) - list.get(0));
            }
        }
        return max;
    }
}
