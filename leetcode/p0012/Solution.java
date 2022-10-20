class Solution {
    private static final Map<Integer, String> map = new LinkedHashMap<>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int cur = num;

        while(cur > 0) {
            for(Map.Entry<Integer, String> entry : map.entrySet()) {
                if (cur >= entry.getKey()) {
                    sb.append(entry.getValue());
                    cur -= entry.getKey();
                    break;
                }
            }
        }
        return sb.toString();
    }
}
