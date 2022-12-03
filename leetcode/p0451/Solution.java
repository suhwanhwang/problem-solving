class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        Collections.sort(list, (a, b) -> {
            int freqA = map.getOrDefault(a, 0);
            int freqB = map.getOrDefault(b, 0);
            if (freqA == freqB) {
                return a - b;
            }
            return -(freqA - freqB);
        });
        
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
