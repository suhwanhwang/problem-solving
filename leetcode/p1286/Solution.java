class CombinationIterator {

    private List<String> list = new ArrayList<>();
    private int curIndex = 0;
    private final int combinationLength;
    public CombinationIterator(String characters, int combinationLength) {
        this.combinationLength = combinationLength;
        
        char[] chars = characters.toCharArray();
        Arrays.sort(chars);
        makeCombination(chars, 0, "");
    }
    
    private void makeCombination(char[] chars, int index, String s) {
        if (s.length() == combinationLength) {
            list.add(s);
            return;
        }
        
        for (int i = index; i < chars.length; ++i) {
            makeCombination(chars, i + 1, s + chars[i]);
        }
    }
    
    
    public String next() {
        return list.get(curIndex++);
    }
    
    public boolean hasNext() {
        return (curIndex <list.size());
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
