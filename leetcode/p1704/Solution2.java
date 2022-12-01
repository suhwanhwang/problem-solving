class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length()/2;
        return getVowel(s.substring(0, mid)) == getVowel(s.substring(mid));
    }

    private static final Character[] vowels = {'a', 'e', 'i', 'o', 'u'};

    private int getVowel(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>(Arrays.asList(vowels));

        for (char c : s.toCharArray()) {
            if (set.contains(Character.toLowerCase(c))) {
                count++;
            }
        }
        return count;
    }
}
