class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int lastVowelIndex = s.length();
        for (int i = 0; i < chars.length; ++i) {
            if (isVowels(chars[i])) {
                for (int j = lastVowelIndex - 1; j >= 0; --j) {
                    if (isVowels(s.charAt(j))) {
                        lastVowelIndex = j;
                        break;
                    }
                }
                chars[i] = s.charAt(lastVowelIndex);
            }
        }
        return new String(chars);
    }

    private boolean isVowels(char c) {
        c = Character.toLowerCase(c);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
