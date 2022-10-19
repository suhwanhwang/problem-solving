class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(key);
        }
        Collections.sort(list, (a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return a.compareTo(b);    
            }
            return -(map.get(a) - map.get(b));
        });
        return list.subList(0, k);
    }
}
