// https://leetcode.com/problems/insert-delete-getrandom-o1/description/
class RandomizedSet {

    Random random = new Random();
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            //System.out.println(map);
            return false;
        }
        
        list.add(val);
        map.put(val, list.size() - 1);
        //System.out.println(map);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            //System.out.println(map);
            return false;
        }
        
        int index = map.get(val);
        int swapVal = list.get(list.size()-1);
        Collections.swap(list, index, list.size()-1);
        list.remove(list.size()-1);
        map.remove(val);
        if(val != swapVal) {
            map.put(swapVal, index);
        }
        //System.out.println(map);
        return true;
    }
    
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
