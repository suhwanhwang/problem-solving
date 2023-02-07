class Solution {
    /*
    0 1 2 2
b     ^
i         ^
map 
    1:1
    2:2
max 3

    */

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();

        int begin = 0;
        int max = 0;
        for (int i = 0; i < fruits.length; ++i) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while(map.size() > 2) {
                map.put(fruits[begin], map.get(fruits[begin]) - 1);
                if (map.get(fruits[begin]) == 0) {
                    map.remove(fruits[begin]);
                }
                begin++;
            }
            max = Math.max(max, i - begin + 1);
        }
        return max;    
    }
}
