package practiceTopics;

public class ReverseSentanceAndWords {

    // Method 1: Reverse the order of words
    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        String reversedSentence = "";
        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence += words[i] + " ";
        }
        return reversedSentence.trim();
    }

    // Method 2: Reverse each word individually (but keep same order)
    public static String reverseEachWord(String str) {
        String[] words = str.split(" ");
        String reversedSentence = "";
        for (String word : words) {
            String reversedWord = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                reversedWord += word.charAt(i);
            }
            reversedSentence += reversedWord + " ";
        }
        return reversedSentence.trim();
    }

    // ✅ Method 3: Reverse BOTH word order AND characters of each word
    public static String reverseWords(String str, boolean reverseCharsToo) {
        String[] words = str.split(" ");
        String reversedSentence = "";
        for (int i = words.length - 1; i >= 0; i--) {
            String reversedWord = "";
            if (reverseCharsToo) {
                for (int j = words[i].length() - 1; j >= 0; j--) {
                    reversedWord += words[i].charAt(j);
                }
            } else {
                reversedWord = words[i];
            }
            reversedSentence += reversedWord + " ";
        }
        return reversedSentence.trim();
    }

    public static void main(String[] args) {
        String name = "I love Java programming";

        String result1 = reverseWords(name);
        String result2 = reverseEachWord(name);
        String result3 = reverseWords(name, true);

        System.out.println("Original: " + name);
        System.out.println("Reversed by word order: " + result1);
        System.out.println("Reversed each word: " + result2);
        System.out.println("Reversed both order and characters: " + result3);
    }
}
