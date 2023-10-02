class Solution {
    /*
    public boolean winnerOfGame(String colors) {
        return helper(new StringBuilder(colors), true);  
    }
    
    private boolean helper(StringBuilder colors, boolean isAlice) {        
        int index = getRemovable(colors, isAlice);
        if (index == -1) {
            return !isAlice;
        }
        colors.deleteCharAt(index);
        return helper(colors, !isAlice);
    }
    
    private int getRemovable(StringBuilder colors, boolean isAlice) {
        if (colors.length() < 3) {
            return -1;
        }

        char c = (isAlice ? 'A' : 'B');
        for (int i = 1; i < colors.length() - 1; ++i) {
            if (colors.charAt(i - 1) == c 
               && colors.charAt(i) == c
               && colors.charAt(i + 1) == c) {
                return i;
            }
        }
        return -1;
    }
    */
    public boolean winnerOfGame(String colors) {
        List<Integer> alice = getRemovable(colors, true);
        List<Integer> bob = getRemovable(colors, false);
        return (alice.size() > bob.size());
    }
    
    private List<Integer> getRemovable(String colors, boolean isAlice) {
        List<Integer> list = new ArrayList<>();
        if (colors.length() < 3) {
            return list;
        }

        char c = (isAlice ? 'A' : 'B');
        for (int i = 1; i < colors.length() - 1; ++i) {
            if (colors.charAt(i - 1) == c 
               && colors.charAt(i) == c
               && colors.charAt(i + 1) == c) {
                list.add(i);
            }
        }
        return list;
    }
}
