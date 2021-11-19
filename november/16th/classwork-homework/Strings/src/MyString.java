import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyString implements Action {
    private String string;
    private int length;

    public MyString(String string) {
        this.string = string;
        this.length = string.length();
    }

    public String getString() {
        return string;
    }

    @Override
    public void printLastCharacter() {
        if (string.isEmpty()) {
            System.out.println("String is empty.");
        } else {
            System.out.println(string.charAt(length-1));
        }
    }

    @Override
    public boolean isEndWith(String expression) {
        return string.endsWith(expression);
    }

    @Override
    public boolean isStartWith(String expression) {
        return string.startsWith(expression);
    }

    @Override
    public boolean isContains(String expression) {
        return string.contains(expression);
    }

    @Override
    public int getPosition(String expression) {
        return string.indexOf(expression);
    }

    @Override
    public String substringExpression(String expression) {
        return string.substring(getPosition(expression), getPosition(expression) + expression.length());
    }

    @Override
    public void getPalindromes() {
        System.out.println(getWords().stream()
                .filter(word -> isPalindrome(word))
                .collect(Collectors.toSet()));
    }

    @Override
    public boolean isPalindrome(String word) {
         return IntStream.range(0, word.length() / 2)
                 .map(number -> word.charAt(number) - word.charAt(word.length() - 1 - number))
                 .sum() == 0;
    }

    @Override
    public Set<String> getWords() {
        return Arrays.stream(string.split("[^A-Za-zА-Яа-я]+")).collect(Collectors.toSet());
    }

    @Override
    public String getExpression(String... strings) {
        return Arrays.stream(strings)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    @Override
    public Set<String> getWordsWithLength(int lowBound, int highBound) {
        return getWords().stream()
                .filter(word -> word.length() >= lowBound && word.length() <= highBound)
                .collect(Collectors.toSet());
    }

    @Override
    public String getMinWord() {
        return getWords().stream().min(Comparator.comparingInt(String::length)).orElseThrow();
    }

    @Override
    public String getMaxWord() {
        return getWords().stream().max(Comparator.comparingInt(String::length)).orElseThrow();
    }

    @Override
    public String join(String firstWord, String secondWord) {
        if (firstWord.length() % 2 == 0 && secondWord.length() % 2 == 0) {
            return firstWord.substring(0, firstWord.length() / 2) +
                    secondWord.substring(secondWord.length() / 2);
        } else {
            return "Enter words with an even number of characters";
        }
    }

    public String rebus() {
        return "сова".substring(0, 3) +
                "семь".substring(0, 3) +
                new StringBuilder("ухо").reverse() +
                "eли";
    }
}
