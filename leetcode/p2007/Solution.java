class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(changed);
        for (int num : changed) {
            if (num % 2 == 0) {
                if (map.getOrDefault(num / 2, 0) > 0) {
                    map.put(num / 2, map.getOrDefault(num / 2, 0) - 1);
                    list.add(num / 2);
                    continue;
                }
            }
            /*
            if (map.getOrDefault(num * 2, 0) > 0) {
                map.put(num * 2, map.getOrDefault(num * 2, 0) - 1);
                list.add(num);
                continue;
            } 
*/
            
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        if (list.size() != changed.length / 2) {
            return new int[0];
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
