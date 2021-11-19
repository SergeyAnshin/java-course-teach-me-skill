import java.util.Set;

public interface Action {

    void printLastCharacter();

    boolean isEndWith(String expression);

    boolean isStartWith(String expression);

    boolean isContains(String expression);

    int getPosition(String expression);

    String substringExpression(String expression);

    void getPalindromes();

    boolean isPalindrome(String word);

    Set<String> getWords();

    Set<String> getWordsWithLength(int lowBound, int highBound);

    String getMinWord();

    String getMaxWord();

    String getExpression(String...strings);

    String join(String firstWord, String secondWord);

}
