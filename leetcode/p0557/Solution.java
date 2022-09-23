class Solution {
    public String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
            .map(word -> new StringBuilder(word).reverse().toString())
            .collect(Collectors.joining(" "));
    }
}
