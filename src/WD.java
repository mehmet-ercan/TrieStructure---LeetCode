public class WD {
    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        //WordDictionary2 wd = new WordDictionary2();

        wd.addWord("bad");

        System.out.println(wd.search("pad"));
        System.out.println(wd.search("bad"));
        System.out.println(wd.search("b.."));

    }
}
