class Solution {
    public String removeDuplicates(String s, int k) {
        List<Character> list = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        for (char c : s.toCharArray()) {
            int count = 1;
            if (list.size() > 0 && c == list.get(list.size()-1)) {
                count += counts.get(counts.size()-1);
            }
            counts.add(count);
            list.add(c);
            
            if (count >= k) {
                count = count - (count % k);
                int right = list.size();
                counts.subList(right - count,right).clear();
                list.subList(right - count,right).clear();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
