class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        Arrays.sort(arr);
        
        for (int num : arr) {
            if (map.getOrDefault(num * 2, 0) > 0) {
                count++;
                map.put(num * 2, map.get(num * 2)-1);
            } else if (num%2==0 && map.getOrDefault(num / 2, 0) > 0) {
                count++;
                map.put(num / 2, map.get(num / 2)-1);
            } else {
                map.put(num, map.getOrDefault(num,0)+1);
            }
            //System.out.println(num + " " + count);
        }
        //System.out.println(count);
        return count == arr.length/2;
    }
}
