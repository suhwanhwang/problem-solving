class Solution {
    public boolean validUtf8(int[] data) {
        int index = 0;
        while (index < data.length) {
            int cur = data[index];
            
            int firstOne = getFirstOneCount(cur);
            if (firstOne == 0) {
                index++;
                continue;
            } else if (firstOne == 1) {
                return false;
            } else if (firstOne > 4) {
                return false;
            }
            
            for (int i = 1; i < firstOne; ++i) {
                if (index + i >= data.length) {
                    return false;
                }
                int d = data[index + i];
                if ((d & 0xc0) != 0x80) {
                    return false;
                }
            }
            index += firstOne;
        }
        return true;
    }
    
    private int getFirstOneCount(int data) {
        int count = 0;
        for (int i = 0; i < 8; ++i) {
            if ((data & 0x80) != 0) {
                count++;
                data <<= 1;
            }
        }
        return count;
    }
}
