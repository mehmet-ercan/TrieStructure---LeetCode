public class WordDictionary {
    public WordDictionary() {
        root = new TrieNode();
    }

    final int ALPHABET_SIZE = 26;
    //index 26th = '.'

    public class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    public TrieNode root;

    public void addWord(String word) {
        int level;
        int length = word.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = word.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    public boolean search(String word) {
        int level;
        int length = word.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = word.charAt(level) - 'a';

            if (word.charAt(level) == '.') {
                for (TrieNode td : pCrawl.children) {
                    if (td != null && search(word.substring(level + 1)))
                        return true;

                    return false;
                }
            }

            if (pCrawl.children[index] == null) {
                return false;
            }

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl.isEndOfWord);
    }
}

/*
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
