class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int numCount = getNumCount(low);
        int base = getSeqBase(numCount);
        List<Integer> ans = new ArrayList<>();
        int cur = base;
        while (cur <= high) {
            if (cur >= low) {
                ans.add(cur);
            }
            cur = getNextSeq(cur);
        }
        return ans;
    }
    
    private int getNumCount(int num) {
        int temp = num;
        int count = 0;
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        return count;
    }
    
    private int getSeqBase(int count) {
        int seq = 0;
        for (int i = 1; i <= count; ++i) {
            seq = seq * 10 + i;
        }
        return seq;
    }
    
    private int getNextSeq(int seq) {
        int count = getNumCount(seq);
        int inc = 0;
        for(int i = 1; i <= count; ++i) {
            inc = inc * 10 + 1;
        }
        int next = seq + inc;
        
        return (next % 10 == 0) ? getSeqBase(count + 1) : next;
    }
}
