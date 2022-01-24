class Solution {
    public boolean detectCapitalUse2(String word) {
        boolean isFirstCapital = Character.isUpperCase(word.charAt(0));
        boolean isSecondCapital = (word.length() > 1 ? Character.isUpperCase(word.charAt(1)) : false);
        if (!isFirstCapital && isSecondCapital) {
            return false;
        }
        
        for (int i = 2; i < word.length(); ++i) {
            if (isFirstCapital) {
                if (Character.isUpperCase(word.charAt(i))) {
                    if (!isSecondCapital) {
                        return false;
                    }
                } else {
                    if (isSecondCapital) {
                        return false;
                    }
                }
            } else {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean detectCapitalUse(String word) {
        return word.matches("([A-Z]+|[A-Z][a-z]*|[a-z]+)");
    }
}
