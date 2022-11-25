class WordDictionary {
    private WordDictionary[] children;
    boolean isEndOfWord;

    public WordDictionary() {
        children = new WordDictionary[26];
        isEndOfWord = false;
    }


    public void addWord(String word) {
        int level;
        int length = word.length();
        int index;

        WordDictionary letter = this;

        for (level = 0; level < length; level++) {
            index = word.charAt(level) - 'a';

            if (letter.children[index] == null)
                letter.children[index] = new WordDictionary();

            letter = letter.children[index];
        }

        letter.isEndOfWord = true;
    }

    public boolean search(String word) {
        WordDictionary temp = this;

        for (int level = 0; level < word.length(); level++) {
            int index = word.charAt(level) - 'a';

            if (word.charAt(level) == '.') {
                for (WordDictionary wd : temp.children) {
                    if (wd != null && wd.search(word.substring(level + 1)))
                        return true;
                }
                return false;
            }

            if (temp.children[index] == null) {
                return false;
            }

            temp = temp.children[index];
        }

        return (temp != null && temp.isEndOfWord);
    }
}

/*
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
