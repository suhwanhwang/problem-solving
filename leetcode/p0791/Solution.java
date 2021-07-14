/*
https://leetcode.com/problems/custom-sort-string/

*/
class Solution {
    public String customSortString(String order, String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); ++i) {
            map.put(order.charAt(i), i);
        }
        
        List<Character> sorted = new ArrayList<>();
        for (int i = 0; i < str.length(); ++i) {
            sorted.add(str.charAt(i));
        }
        Collections.sort(sorted, (c1, c2) -> {
            int order1 = map.getOrDefault(c1, -1);
            int order2 = map.getOrDefault(c2, -1);
            return order1 - order2;
        });
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            sb.append(sorted.get(i));
        }
    
        return sb.toString();
    }
}
