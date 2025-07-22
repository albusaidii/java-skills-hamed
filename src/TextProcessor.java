public class TextProcessor {

    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }


    public static String replaceWord(String text, String oldWord, String newWord) {
        return text.replace(oldWord, newWord);
    }

    public static void main(String[] args) {
        String sentence = "Java is fun and Java is powerful";


        int wordCount = countWords(sentence);
        System.out.println("Word Count: " + wordCount);


        String updatedSentence = replaceWord(sentence, "Java", "Programming");
        System.out.println("Updated Sentence: " + updatedSentence);
    }
}
