class Solution {
    /*
    w -> prefix + postfix
    f(w) -> f(prefix) + f(postfix)
    */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        final Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        final List<String> concatenatedWords = new ArrayList<>();

        for (String word : words) {
            wordSet.remove(word);
            if (dfs(wordSet, word, 0, new boolean[word.length()])) {
                concatenatedWords.add(word);
            }
            wordSet.add(word);
        }

        return concatenatedWords;
    }

    private boolean dfs(Set<String> wordSet, String word, int length, boolean[] visited) {
        if (length == word.length()) {
            return true;
        }

        if (visited[length]) {
            return false;
        }

        visited[length] = true;

        for (int i = word.length(); i > length; --i) {
            if (wordSet.contains(word.substring(length, i)) && dfs(wordSet, word, i, visited)) {
                return true;
            }
        }

        return false;
    }
}
