import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TextFormatter {

    public static boolean isPalindrome(String word) {
        if (word != null && !word.isBlank()) {
            String trimWord = word.replaceAll("\s", "");
            return IntStream.range(0, trimWord.length() / 2)
                    .map(number -> trimWord.charAt(number) - trimWord.charAt(trimWord.length() - 1 - number))
                    .sum() == 0;
        }
        return false;
    }

    public static int getNumberWordsInSentence(String sentence) {
        return sentence.split(" ").length;
    }

    public static boolean thereIsPalindromeInSentence(String sentence) {
        return Arrays.stream(sentence.split(" ")).anyMatch(TextFormatter::isPalindrome);
    }

    public static List<String> getSentencesWithInvalidWords(List<String> sentences, List<String> words) {
        return sentences.stream()
                .filter(s -> {
                    var list = new ArrayList<>(List.of(s.toLowerCase()
                            .replaceAll("[^A-za-z ]", " ")
                            .split(" ")));
                    list.retainAll(words);
                    return list.size() > 0; })
                .collect(Collectors.toList());
    }

    public static List<String> getSentencesWithInvalidWordsTwo(String sentence, List<String> words) {
        List<String> sentenceWord = new ArrayList<>(List.of(sentence.toLowerCase()
                .replaceAll("[^A-za-z ]", " ")
                .split(" ")));
        sentenceWord.retainAll(words);
        return sentenceWord;
    }

    public static boolean isInvalidWordsInSentence(String sentence, List<String> words) {
        List<String> sentenceWord = new ArrayList<>(List.of(sentence.toLowerCase()
                .replaceAll("[^A-za-z ]", " ")
                .split(" ")));
        for (String s : sentenceWord) {
            if (words.contains(s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInvalidWordsInSentenceBinarySearch(String sentence, List<String> words) {
        String[] sentenceWord = sentence.toLowerCase()
                .replaceAll("[^A-za-z ]", " ")
                .split(" ");
        Arrays.sort(sentenceWord);
        for (int i = 0; i < words.size(); i++) {
            if (Arrays.binarySearch(sentenceWord, words.get(i)) >= 0) {
                return true;
            }
        }
        return false;
    }
}
